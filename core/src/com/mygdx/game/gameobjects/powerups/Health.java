package com.mygdx.game.gameobjects.powerups;

import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.characters.Character;

public class Health extends Powerup {
    protected Health(Drop game) {
        super(game);

        setCollider(new ColliderHealthPickup(new RectangleCollider(game, this)));
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

            if (otherGameObject instanceof Character) {
                Character character = (Character) otherGameObject;
                character.getAbilities().heal(10);

                getGameObject().markForDestruction();
            }
        }
    }
}
