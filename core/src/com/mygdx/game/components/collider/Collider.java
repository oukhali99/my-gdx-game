package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class Collider extends BaseComponent {
    private LinkedList<GameObject> collisionObjectsThisFrame;

    public Collider(Drop game, GameObject gameObject) {
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

    @Override
    public void destroy() {

    }

    public abstract void handleCollision(GameObject otherGameObject);

    public LinkedList<GameObject> getCollisionObjectsThisFrame() {
        return collisionObjectsThisFrame;
    }

    protected abstract Rectangle getArea();
}
