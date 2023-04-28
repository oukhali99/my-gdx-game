package com.mygdx.game.components.collider;

import com.mygdx.game.gameobjects.GameObject;

public class DestroyOtherGameObjectCollider extends BaseColliderDecorator {
    public DestroyOtherGameObjectCollider(Collider baseCollider) {
        super(baseCollider);
    }

    @Override
    public void handleCollisionDecorator(GameObject otherGameObject) {
        otherGameObject.markForDestruction();
        super.handleCollision(otherGameObject);
    }
}
