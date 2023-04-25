package com.mygdx.game.components.collider;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class CustomCollider extends BaseCollider {
    private List<CollisionRunnable> collisionRunnablesThisFrame = new LinkedList<>();

    public CustomCollider(Drop game) {
        super(game);
    }


    @Override
    public void postUpdate(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        collisionRunnablesThisFrame.clear();

        for (GameObject otherGameObject : gameObjects) {
            BaseCollider otherBaseCollider = otherGameObject.getCollider();
            if (
                    otherBaseCollider != null &&
                    overlaps(otherBaseCollider) &&
                    this != otherBaseCollider
            ) {
                onCollision(otherGameObject);
            }
        }
    }

    private boolean overlaps(BaseCollider otherCollider) {
        return getArea().overlaps(otherCollider.getArea()) || otherCollider.getArea().overlaps(getArea());
    }

    @Override
    public void postPostUpdate(float delta) {
        for (CollisionRunnable collisionRunnable : collisionRunnablesThisFrame) {
            collisionRunnable.run(collisionRunnable.otherGameObject);
        }
    }

    @Override
    public void onCollision(GameObject otherObject) {
        CollisionRunnable runnable = getOnCollisionRunnable();
        runnable.setOtherGameObject(otherObject);
        collisionRunnablesThisFrame.add(runnable);
    }

    @Override
    public void destroy() {

    }

    public abstract CollisionRunnable getOnCollisionRunnable();


    public static abstract class CollisionRunnable {
        private GameObject otherGameObject;

        public void setOtherGameObject(GameObject otherGameObject) {
            this.otherGameObject = otherGameObject;
        }

        public abstract void run(GameObject otherGameObject);
    }
}
