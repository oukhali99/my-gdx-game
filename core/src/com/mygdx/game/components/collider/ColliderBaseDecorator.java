package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderBaseDecorator extends Collider {
    private Collider baseCollider;

    public ColliderBaseDecorator(Collider baseCollider) {
        super(baseCollider.getGame(), baseCollider.getGameObject());
        this.baseCollider = baseCollider;
    }

    @Override
    public void lookForCollisions(float delta, List<GameObject> gameObjects) {
        baseCollider.lookForCollisions(delta, gameObjects);
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        baseCollider.handleCollision(otherGameObject);
    }

    @Override
    public LinkedList<GameObject> getCollisionObjectsThisFrame() {
        return baseCollider.getCollisionObjectsThisFrame();
    }

    @Override
    public Rectangle getArea() {
        return baseCollider.getArea();
    }

    @Override
    public void destroy() {
        baseCollider.destroy();
    }

    @Override
    public void setGameObject(GameObject gameObject) {
        super.setGameObject(gameObject);
        baseCollider.setGameObject(gameObject);
    }
}
