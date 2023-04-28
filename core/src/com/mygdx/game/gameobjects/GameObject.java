package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.NoCollisions;
import com.mygdx.game.components.renderer.NoTexture;
import com.mygdx.game.components.renderer.Renderer;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    protected Transform transform;
    private boolean markedForDestruction;
    protected List<GameObject> children;
    private final List<GameObject> collisionObjectsThisFrame;
    private Renderer renderer;
    private Collider collider;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game, this);
        this.markedForDestruction = false;
        this.children = new LinkedList<>();
        this.collisionObjectsThisFrame = new LinkedList<>();

        this.renderer = new NoTexture(game, this);
        this.collider = new NoCollisions(game, this);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }

    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    public void setPosition(Vector2 position) {
        transform.setPosition(new Vector2(position));
    }

    public Vector2 getPosition() {
        return transform.getPosition();
    }

    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }

    public void setScale(Vector2 scale) {
        transform.setScale(new Vector2(scale));
    }

    public Vector2 getScale() {
        return transform.getScale();
    }

    public Collider getCollider() {
        return collider;
    }

    public Transform getTransform() {
        return new Transform(transform);
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
            }
            else {
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
        getRenderer().render(delta);

        for (GameObject child : getChildren()) {
            child.getRenderer().render(delta);
        }
    }

    public void update(float delta) {
    }

    public void postUpdate(float delta, List<GameObject> gameObjects) {
        getCollider().lookForCollisions(delta, gameObjects);

        for (GameObject child : getChildren()) {
            child.getCollider().lookForCollisions(delta, gameObjects);
        }
    }

    public void postPostUpdate(float delta) {
        getCollider().handleCollisionsThisFrame(delta);

        for (GameObject child : getChildren()) {
            child.getCollider().handleCollisionsThisFrame(delta);
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
}
