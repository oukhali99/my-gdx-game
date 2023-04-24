package com.mygdx.game.gameobjects.combat.combatactors.enemy;

import com.badlogic.gdx.Screen;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;
import com.mygdx.game.gameobjects.combat.combatactors.Player;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;

public class Enemy extends CombatActor {
    public Enemy(Drop game) {
        super(game);

        final Drop finalGame = game;
        final CombatActor finalGameObject = this;

        setPosition(16*20, 16*20);
        setScale(16, 16);

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run() {
                if (otherGameObject instanceof Player) {
                    Screen combatScreen = new CombatScreen(
                            finalGame,
                            finalGame.getScreen(),
                            new CombatScreen.Fight((Player) otherGameObject, finalGameObject)
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
