package com.mygdx.game.components.collider;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseCollider extends BaseComponent implements Collider {
    private final LinkedList<GameObject> collisionObjectsThisFrame;

    public BaseCollider(Drop game, GameObject gameObject) {
        super(game, gameObject);
        collisionObjectsThisFrame = new LinkedList<>();
    }

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

    private void onCollision(GameObject otherObject) {
        collisionObjectsThisFrame.add(otherObject);
    }

    public LinkedList<GameObject> getCollisionObjectsThisFrame() {
        return collisionObjectsThisFrame;
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        getGameObject().getMovement().onCollision(otherGameObject);
    }
}
