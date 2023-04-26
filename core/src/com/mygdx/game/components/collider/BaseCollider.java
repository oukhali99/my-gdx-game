package com.mygdx.game.components.collider;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseCollider extends BaseComponent implements Collider {
    private List<GameObject> collisionObjectsThisFrame = new LinkedList<>();

    public BaseCollider(Drop game) {
        super(game);
    }

    @Override
    public void lookForCollisions(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        collisionObjectsThisFrame.clear();

        for (GameObject otherGameObject : gameObjects) {
            Collider otherBaseCollider = otherGameObject.getCollider();
            if (
                    otherBaseCollider != null &&
                    overlaps(gameObject, otherGameObject, otherBaseCollider) &&
                    !this.equals(otherBaseCollider)
            ) {
                onCollision(otherGameObject);
            }
        }
    }

    private boolean overlaps(GameObject gameObject, GameObject otherGameObject, Collider otherCollider) {
        return getArea(gameObject).overlaps(otherCollider.getArea(otherGameObject)) || otherCollider.getArea(otherGameObject).overlaps(getArea(gameObject));
    }

    @Override
    public void handleCollisionsThisFrame(GameObject gameObject, float delta) {
        for (GameObject otherGameObject : collisionObjectsThisFrame) {
            gameObject.onCollision(gameObject, otherGameObject);
        }
    }

    @Override
    public List<GameObject> getCollisionObjectsThisFrame() {
        return collisionObjectsThisFrame;
    }

    private void onCollision(GameObject otherObject) {
        collisionObjectsThisFrame.add(otherObject);
    }

    @Override
    public void destroy() {

    }
}
