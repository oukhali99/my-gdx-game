package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.collider.CustomCollider;
import com.mygdx.game.components.renderer.HealthDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.components.updater.NoUpdate;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public class Player extends BaseGameObject {
    public Player(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        baseUpdater = new WASDMovement(new NoUpdate(game), 8);
        renderer = new HealthDependentTexture(new MyTexture(game, "bucket.png"));

        final GameObject thisGameObject = this;
        baseCollider = new CustomCollider(game) {
            @Override
            public Rectangle getArea() {
                Transform transform = getTransform();
                Rectangle rectangle = new Rectangle();
                rectangle.x = transform.getPosition().x;
                rectangle.y = transform.getPosition().y;
                rectangle.width = transform.getScale().x;
                rectangle.height = transform.getScale().y;
                return rectangle;
            }
        };

        abilities = new Abilities(game);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
        super.onCollision(otherGameObject);
        baseUpdater.onCollision(this, otherGameObject);
    }
}
