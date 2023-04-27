package com.mygdx.game.components.collider;

import com.mygdx.game.gameobjects.GameObject;

public class DestroyOtherGameObjectCollider extends BaseColliderDecorator {
    public DestroyOtherGameObjectCollider(Collider baseCollider) {
        super(baseCollider);
    }
    @Override
    public void handleCollisionsThisFrame(GameObject gameObject, float delta) {
        for (GameObject otherGameObject : gameObject.getCollisionObjectsThisFrame()) {
            otherGameObject.markForDestruction();
        }
        super.handleCollisionsThisFrame(gameObject, delta);
    }
}
