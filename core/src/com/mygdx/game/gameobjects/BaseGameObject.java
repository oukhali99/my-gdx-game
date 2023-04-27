package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.NoCollisions;
import com.mygdx.game.components.renderer.NoTexture;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.components.updater.NoUpdate;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseGameObject implements GameObject {
    protected final Drop game;
    protected Transform transform;
    private boolean markedForDestruction;
    protected List<GameObject> children;
    private final List<GameObject> collisionObjectsThisFrame;

    protected BaseGameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game);
        this.markedForDestruction = false;
        this.children = new LinkedList<>();
        this.collisionObjectsThisFrame = new LinkedList<>();
    }

    public Renderer getRenderer() {
        return new NoTexture(game);
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
        return new NoCollisions(game);
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

    public void onCollision(GameObject gameObject, GameObject otherGameObject) {
    }

    @Override
    public void translate(Vector2 amount) {
        transform.translate(amount);
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        gameObject.getRenderer().render(gameObject, delta);

        for (GameObject child : gameObject.getChildren()) {
            child.getRenderer().render(child, delta);
        }
    }

    @Override
    public void update(GameObject gameObject, float delta) {
    }

    @Override
    public void postUpdate(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        gameObject.getCollider().lookForCollisions(delta, gameObjects, gameObject);

        for (GameObject child : gameObject.getChildren()) {
            child.getCollider().lookForCollisions(delta, gameObjects, child);
        }
    }

    @Override
    public void postPostUpdate(GameObject gameObject, float delta) {
        gameObject.getCollider().handleCollisionsThisFrame(gameObject, delta);

        for (GameObject child : gameObject.getChildren()) {
            child.getCollider().handleCollisionsThisFrame(child, delta);
        }
    }

    @Override
    public List<GameObject> getCollisionObjectsThisFrame() {
        return new LinkedList<>(collisionObjectsThisFrame);
    }

    @Override
    public void clearCollisionObjectsThisFrame() {
        collisionObjectsThisFrame.clear();
    }

    @Override
    public void addCollisionObjectThisFrame(GameObject gameObject) {
        collisionObjectsThisFrame.add(gameObject);
    }
}
