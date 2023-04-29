package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.ComponentBaseDecorator;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderBaseDecorator extends ComponentBaseDecorator implements Collider {
    private Collider baseCollider;

    public ColliderBaseDecorator(Collider baseCollider) {
        super(baseCollider);
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
}
