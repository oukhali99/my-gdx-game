package com.mygdx.game.gameobjects.combat.enemy;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.collider.CustomCollider;
import com.mygdx.game.components.renderer.HealthDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.Player;
import com.mygdx.game.gameplay.Snowball;
import com.mygdx.game.screens.CombatScreen;

import java.util.Random;

public abstract class Enemy extends BaseGameObject {
    public Enemy(Drop game) {
        super(game);

        final Drop finalGame = game;
        final GameObject finalGameObject = this;

        setPosition(16*20, 16*20);
        setScale(16, 16);

        renderer = new HealthDependentTexture(new MyTexture(game, getTexturePath()));

        abilities = new Abilities(game);
        abilities.addAbility(new Snowball(game));

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
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
        super.onCollision(otherGameObject);
        if (otherGameObject instanceof Player) {
            Screen combatScreen = new CombatScreen(
                    game,
                    game.getScreen(),
                    new CombatScreen.Fight(
                            otherGameObject,
                            this
                    )
            );
            game.setScreen(combatScreen);
        }
        else {
            Random random = new Random();
            boolean xPositive = random.nextFloat() < 0.5f;
            boolean yPositive = random.nextFloat() < 0.5f;
            transform.translate(xPositive ? 16 : -16, yPositive ? 16 : -16);
        }
    }

    protected abstract String getTexturePath();
}
