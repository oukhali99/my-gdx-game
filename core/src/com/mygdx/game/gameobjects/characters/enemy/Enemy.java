package com.mygdx.game.gameobjects.characters.enemy;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.attacks.Attack;
import com.mygdx.game.gameobjects.characters.Character;
import com.mygdx.game.gameobjects.characters.Player;
import com.mygdx.game.screens.CombatScreen;

import java.util.Random;

public abstract class Enemy extends Character {
    public Enemy(final Drop game) {
        super(game);

        setCollider(new ColliderBaseDecorator(getCollider()) {
            @Override
            public void handleCollision(GameObject otherGameObject) {
                super.handleCollision(otherGameObject);

                if (!(otherGameObject instanceof Attack)) {
                    Random random = new Random();
                    boolean xPositive = random.nextFloat() < 0.5f;
                    boolean yPositive = random.nextFloat() < 0.5f;
                    transform.translate(xPositive ? 16 : -16, yPositive ? 16 : -16);

                    if (otherGameObject instanceof Player) {
                        final Character player = (Player) otherGameObject;
                        Screen combatScreen = new CombatScreen(
                                game,
                                game.getScreen(),
                                new CombatScreen.Fight(
                                        player.clone(),
                                        ((Character) getGameObject()).clone()
                                )
                        );
                        game.setScreen(combatScreen);
                    }
                }
            }
        });
    }
}