package com.mygdx.game.gameobjects.enemy;

import com.badlogic.gdx.Screen;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Texture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.Player;

public class Enemy extends GameObject {
    public Enemy(Drop game) {
        super(game);

        final Drop finalGame = game;
        final GameObject finalGameObject = this;

        setPosition(16*20, 16*20);
        setScale(16, 16);

        addComponent(new Texture(game, getTexturePath()));

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run() {
                if (otherGameObject instanceof Player) {
                    Screen combatScreen = new CombatScreen(
                            finalGame,
                            finalGame.getScreen(),
                            new CombatScreen.Fight(otherGameObject, finalGameObject)
                    );
                    finalGame.setScreen(combatScreen);
                }
            }
        });
        addComponent(collider);
    }

    protected String getTexturePath() {
        return "droplet.png";
    }
}
