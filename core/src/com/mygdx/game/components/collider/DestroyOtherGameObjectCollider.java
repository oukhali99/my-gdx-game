package com.mygdx.game.components.collider;

import com.mygdx.game.gameobjects.GameObject;

public class DestroyOtherGameObjectCollider extends ColliderBaseDecorator {
    public DestroyOtherGameObjectCollider(Collider baseCollider) {
        super(baseCollider);
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        otherGameObject.markForDestruction();
        super.handleCollision(otherGameObject);
    }
}
