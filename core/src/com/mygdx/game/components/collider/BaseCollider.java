package com.mygdx.game.components.collider;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseCollider extends BaseComponent implements Collider {
    private LinkedList<GameObject> collisionObjectsThisFrame;

    public BaseCollider(Drop game, GameObject gameObject) {
        super(game, gameObject);
        collisionObjectsThisFrame = new LinkedList<>();
    }

    @Override
    public void lookForCollisions(float delta, List<GameObject> gameObjects) {
        collisionObjectsThisFrame.clear();

        for (GameObject otherGameObject : gameObjects) {
            Collider otherBaseCollider = otherGameObject.getCollider();
            if (
                    otherBaseCollider != null &&
                    overlaps(otherBaseCollider) &&
                    gameObject != otherGameObject
            ) {
                onCollision(otherGameObject);
            }
        }
    }

    private boolean overlaps(Collider otherCollider) {
        return getArea().overlaps(otherCollider.getArea()) || otherCollider.getArea().overlaps(getArea());
    }

    @Override
    public void handleCollisionsThisFrame(float delta) {
        for (GameObject otherGameObject : collisionObjectsThisFrame) {
            handleCollision(otherGameObject);
        }
    }

    private void onCollision(GameObject otherObject) {
        collisionObjectsThisFrame.add(otherObject);
    }

    @Override
    public void destroy() {

    }

    @Override
    public LinkedList<GameObject> getCollisionObjectsThisFrame() {
        return collisionObjectsThisFrame;
    }
}
