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
    public void onCollision(GameObject otherObject) {
        baseCollider.onCollision(otherObject);
    }

    @Override
    public void postUpdate(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        baseCollider.postUpdate(delta, gameObjects, gameObject);
    }

    @Override
    public void postPostUpdate(GameObject gameObject, float delta) {
        baseCollider.postPostUpdate(gameObject, delta);
    }

    @Override
    public Rectangle getArea(GameObject gameObject) {
        return baseCollider.getArea(gameObject);
    }
}
