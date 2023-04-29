package com.mygdx.game.gameobjects.powerups;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class Health extends GameObject {
    protected Health(Drop game) {
        super(game);

        setRenderer(new MyTexture(game, this, "droplet.png"));

        setCollider(new ColliderHealthPickup(new RectangleCollider(game, this)));

        getTransform().setScale(new Vector2(16, 16));
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
