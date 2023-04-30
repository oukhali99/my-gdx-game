package com.mygdx.game.gameobjects.powerups;

import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class Health extends Powerup {
    protected Health(Drop game) {
        super(game);

        setCollider(new ColliderHealthPickup(getCollider()));
    }

    @Override
    protected String getTexturePath() {
        return "health-cross.png";
    }

    private static class ColliderHealthPickup extends ColliderBaseDecorator {
        public ColliderHealthPickup(Collider baseCollider) {
            super(baseCollider);
        }

        @Override
        public void handleCollision(GameObject otherGameObject) {
            super.handleCollision(otherGameObject);

                otherGameObject.getAbilities().heal(10);
                getGameObject().markForDestruction();
        }
    }
}
