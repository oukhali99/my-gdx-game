package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.BaseComponentDecorator;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public class BaseColliderDecorator extends BaseComponentDecorator implements Collider {
    private Collider baseCollider;

    public BaseColliderDecorator(Collider baseCollider) {
        super(baseCollider);
        this.baseCollider = baseCollider;
    }

    @Override
    public void lookForCollisions(float delta, List<GameObject> gameObjects) {
        baseCollider.lookForCollisions(delta, gameObjects);
    }

    @Override
    public void handleCollisionsThisFrame(float delta) {
        baseCollider.handleCollisionsThisFrame(delta);
    }

    @Override
    public Rectangle getArea() {
        return baseCollider.getArea();
    }

    @Override
    public LinkedList<GameObject> getCollisionObjectsThisFrame() {
        return baseCollider.getCollisionObjectsThisFrame();
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        baseCollider.handleCollision(otherGameObject);
    }
}
