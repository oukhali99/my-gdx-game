package com.mygdx.game.gameobjects.powerups;

import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class Speed extends Powerup {
    protected Speed(Drop game) {
        super(game);

        setCollider(new ColliderSpeedPowerup(new RectangleCollider(game, this)));
    }

    @Override
    protected String getTexturePath() {
        return "snowball.png";
    }

    private static class ColliderSpeedPowerup extends ColliderBaseDecorator {
        public ColliderSpeedPowerup(Collider baseCollider) {
            super(baseCollider);
        }

        @Override
        public void handleCollision(GameObject otherGameObject) {
            super.handleCollision(otherGameObject);

            if (otherGameObject instanceof Character) {
                Character character = (Character) otherGameObject;

                character.getMovement().applySpeedBoost(2, 2f);

                getGameObject().markForDestruction();
            }
        }
    }
}
