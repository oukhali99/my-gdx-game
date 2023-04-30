package com.mygdx.game.gameobjects.powerups;

import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class Speed extends Powerup {
    protected Speed(Drop game) {
        super(game);

        setCollider(new ColliderSpeedPowerup(getCollider()));
    }

    @Override
    protected String getTexturePath() {
        return "speed-boost.png";
    }

    private static class ColliderSpeedPowerup extends ColliderBaseDecorator {
        public ColliderSpeedPowerup(Collider baseCollider) {
            super(baseCollider);
        }

        @Override
        public void handleCollision(GameObject otherGameObject) {
            super.handleCollision(otherGameObject);

            otherGameObject.getMovement().applySpeedBoost(2, 2f);
            getGameObject().markForDestruction();
        }
    }
}
