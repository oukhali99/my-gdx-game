package com.mygdx.game.components;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public class Collider extends Component {
    private static List<Collider> allColliders = new LinkedList<>();

    private List<CollisionRunnable> onCollisionRunnables = new LinkedList<>();

    private List<CollisionRunnable> collisionRunnablesThisFrame = new LinkedList<>();

    public Collider(Drop game) {
        super(game);
    }

    @Override
    public void postUpdate(float delta) {
        super.postUpdate(delta);

        collisionRunnablesThisFrame.clear();

        for (Collider collider : allColliders) {
            if (
                collider.getArea().overlaps(getArea()) &&
                this != collider
            ) {
                onCollision(collider.gameObject);
            }
        }
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
    public void attachToGameObject(GameObject gameObject) {
        super.attachToGameObject(gameObject);
        allColliders.add(this);
    }

    @Override
    public void destroy() {
        super.destroy();
        allColliders.remove(this);
    }

    @Override
    public void postPostUpdate(float delta) {
        super.postPostUpdate(delta);
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
