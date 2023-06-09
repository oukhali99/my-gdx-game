package com.mygdx.game.components.collider;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class CustomCollider extends BaseCollider {
    private List<CollisionRunnable> collisionRunnablesThisFrame = new LinkedList<>();

    public CustomCollider(Drop game) {
        super(game);
    }


    @Override
    public void postUpdate(float delta, List<GameObject> baseGameObjects, GameObject baseGameObject) {
        collisionRunnablesThisFrame.clear();

        for (GameObject otherBaseGameObject : baseGameObjects) {
            BaseCollider otherBaseCollider = otherBaseGameObject.getCollider();
            if (
                    otherBaseCollider != null &&
                    overlaps(otherBaseCollider) &&
                    this != otherBaseCollider
            ) {
                onCollision(otherBaseGameObject);
            }
        }
    }

    private boolean overlaps(BaseCollider otherCollider) {
        return getArea().overlaps(otherCollider.getArea()) || otherCollider.getArea().overlaps(getArea());
    }

    @Override
    public void postPostUpdate(float delta) {
        for (CollisionRunnable collisionRunnable : collisionRunnablesThisFrame) {
            collisionRunnable.run(collisionRunnable.otherBaseGameObject);
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
        private GameObject otherBaseGameObject;

        public void setOtherGameObject(GameObject otherBaseGameObject) {
            this.otherBaseGameObject = otherBaseGameObject;
        }

        public abstract void run(GameObject otherBaseGameObject);
    }
}
