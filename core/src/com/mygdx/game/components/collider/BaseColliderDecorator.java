package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.BaseComponentDecorator;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public class BaseColliderDecorator extends BaseComponentDecorator implements Collider {
    private Collider baseCollider;

    public BaseColliderDecorator(Collider baseCollider) {
        super(baseCollider);
        this.baseCollider = baseCollider;
    }

    @Override
    public void lookForCollisions(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        baseCollider.lookForCollisions(delta, gameObjects, gameObject);
    }

    @Override
    public void handleCollisionsThisFrame(GameObject gameObject, float delta) {
        baseCollider.handleCollisionsThisFrame(gameObject, delta);
    }

    @Override
    public Rectangle getArea(GameObject gameObject) {
        return baseCollider.getArea(gameObject);
    }
}
