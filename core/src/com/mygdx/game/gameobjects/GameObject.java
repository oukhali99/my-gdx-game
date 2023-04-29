package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.NoCollisions;
import com.mygdx.game.components.renderer.NoTexture;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.transform.BasicTransform;
import com.mygdx.game.components.transform.Transform;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    private final List<GameObject> collisionObjectsThisFrame;
    protected Transform transform;
    protected List<GameObject> children;
    private boolean markedForDestruction;
    private Renderer renderer;
    private Collider collider;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new BasicTransform(game, this);
        this.markedForDestruction = false;
        this.children = new LinkedList<>();
        this.collisionObjectsThisFrame = new LinkedList<>();

        this.renderer = new NoTexture(game, this);
        setCollider(new NoCollisions(game, this));
    }

    public GameObject(GameObject gameObject) {
        this.game = gameObject.game;
        this.collisionObjectsThisFrame = gameObject.collisionObjectsThisFrame;
        this.markedForDestruction = gameObject.markedForDestruction;
        this.children = gameObject.children;

        this.renderer = gameObject.renderer;
        this.collider = gameObject.collider;
        this.transform = gameObject.transform;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    public Vector2 getPosition() {
        return transform.getPosition();
    }

    public void setPosition(Vector2 position) {
        transform.setPosition(new Vector2(position));
    }

    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }

    public Vector2 getScale() {
        return transform.getScale();
    }

    public void setScale(Vector2 scale) {
        transform.setScale(new Vector2(scale));
    }

    public Collider getCollider() {
        return collider;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public boolean isMarkedForDestruction() {
        return markedForDestruction;
    }

    public void markForDestruction() {
        markedForDestruction = true;
    }

    public void destroy() {
        for (GameObject child : children) {
            child.destroy();
        }
    }

    public void preenDestroyedChildren() {
        List<GameObject> enabledGameObjects = new LinkedList<>();
        for (GameObject gameObject : children) {
            if (gameObject.isMarkedForDestruction()) {
                gameObject.destroy();
            } else {
                enabledGameObjects.add(gameObject);
            }
        }
        children = enabledGameObjects;
    }

    public List<GameObject> getChildren() {
        return new LinkedList<>(children);
    }

    public void addChild(GameObject child) {
        children.add(child);
    }

    public Drop getGame() {
        return game;
    }

    public void translate(Vector2 amount) {
        transform.translate(amount);
    }

    public void render(float delta) {
        getRenderer().setGameObject(this);
        getRenderer().render(delta);

        for (GameObject child : getChildren()) {
            child.getRenderer().setGameObject(child);
            child.getRenderer().render(delta);
        }
    }

    public void update(float delta) {
    }

    public void postUpdate(float delta, List<GameObject> gameObjects) {
        getCollider().setGameObject(this);
        getCollider().lookForCollisions(delta, gameObjects);

        for (GameObject child : getChildren()) {
            child.getCollider().setGameObject(child);
            child.getCollider().lookForCollisions(delta, gameObjects);
        }
    }

    public void postPostUpdate(float delta) {
        getCollider().setGameObject(this);
        for (GameObject otherGameObject : getCollider().getCollisionObjectsThisFrame()) {
            getCollider().handleCollision(otherGameObject);
        }

        for (GameObject child : getChildren()) {
            child.getCollider().setGameObject(child);
            for (GameObject otherGameObject : child.getCollider().getCollisionObjectsThisFrame()) {
                child.getCollider().handleCollision(otherGameObject);
            }
        }
    }

    public List<GameObject> getCollisionObjectsThisFrame() {
        return new LinkedList<>(collisionObjectsThisFrame);
    }

    public void clearCollisionObjectsThisFrame() {
        collisionObjectsThisFrame.clear();
    }

    public void addCollisionObjectThisFrame(GameObject gameObject) {
        collisionObjectsThisFrame.add(gameObject);
    }

    @Override
    public GameObject clone() {
        return new GameObject(this) {
        };
    }
}
