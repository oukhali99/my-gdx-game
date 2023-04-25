package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Transform;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public class Collider extends BaseComponent implements Component {
    private List<CollisionRunnable> onCollisionRunnables = new LinkedList<>();

    private List<CollisionRunnable> collisionRunnablesThisFrame = new LinkedList<>();

    public Collider(Drop game) {
        super(game);
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public void postUpdate(float delta) {
        collisionRunnablesThisFrame.clear();

        for (GameObject otherGameObject : game.getScreen().getGameObjects()) {
            Collider collider = (Collider) otherGameObject.getComponent(Collider.class);
            if (
                    collider != null &&
                    collider.getArea().overlaps(getArea()) &&
                    this != collider
            ) {
                onCollision(otherGameObject);
            }
        }
    }

    @Override
    public void destroy() {

    }

    public Rectangle getArea() {
        Transform transform = gameObject.getTransform();
        Rectangle rectangle = new Rectangle();
        rectangle.x = transform.getPosition().x;
        rectangle.y = transform.getPosition().y;
        rectangle.width = transform.getScale().x;
        rectangle.height = transform.getScale().y;
        return rectangle;
    }

    @Override
    public void postPostUpdate(float delta) {
        for (CollisionRunnable collisionRunnable : collisionRunnablesThisFrame) {
            collisionRunnable.run(collisionRunnable.otherGameObject);
        }
    }

    public void onCollision(GameObject otherObject) {
        for (CollisionRunnable runnable : onCollisionRunnables) {
            runnable.setOtherGameObject(otherObject);
            collisionRunnablesThisFrame.add(runnable);
        }
    }

    public void addOnCollisionRunnable(CollisionRunnable runnable) {
        onCollisionRunnables.add(runnable);
    }

    public static abstract class CollisionRunnable {
        private GameObject otherGameObject;

        public void setOtherGameObject(GameObject otherGameObject) {
            this.otherGameObject = otherGameObject;
        }

        public abstract void run(GameObject otherGameObject);
    }
}
