package com.mygdx.game.components.collider;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class CustomCollider extends BaseCollider {
    private List<GameObject> collisionObjectsThisFrame = new LinkedList<>();

    public CustomCollider(Drop game) {
        super(game);
    }


    @Override
    public void postUpdate(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        collisionObjectsThisFrame.clear();

        for (GameObject otherGameObject : gameObjects) {
            BaseCollider otherBaseCollider = otherGameObject.getCollider();
            if (
                    otherBaseCollider != null &&
                    overlaps(gameObject, otherGameObject, otherBaseCollider) &&
                    this != otherBaseCollider
            ) {
                onCollision(otherGameObject);
            }
        }
    }

    private boolean overlaps(GameObject gameObject, GameObject otherGameObject, BaseCollider otherCollider) {
        return getArea(gameObject).overlaps(otherCollider.getArea(otherGameObject)) || otherCollider.getArea(otherGameObject).overlaps(getArea(gameObject));
    }

    @Override
    public void postPostUpdate(GameObject gameObject, float delta) {
        for (GameObject otherGameObject : collisionObjectsThisFrame) {
            gameObject.onCollision(gameObject, otherGameObject);
        }
    }

    @Override
    public void onCollision(GameObject otherObject) {
        collisionObjectsThisFrame.add(otherObject);
    }

    @Override
    public void destroy() {

    }
}
