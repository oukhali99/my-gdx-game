package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseColliderDecorator extends Collider {
    private Collider baseCollider;

    public BaseColliderDecorator(Collider baseCollider) {
        super(baseCollider.getGame(), baseCollider.getGameObject());
        this.baseCollider = baseCollider;
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        baseCollider.handleCollision(otherGameObject);
        handleCollisionDecorator(otherGameObject);
    }

    protected abstract void handleCollisionDecorator(GameObject gameObject);

    @Override
    public Rectangle getArea() {
        return baseCollider.getArea();
    }
}
