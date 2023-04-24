package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.combatmode.CombatModeEnemy;
import com.mygdx.game.gameobjects.combatmode.CombatModeGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combatmode.CombatModePlayer;

public class CombatScreen extends BaseScreen {
    private Screen previousScreen;

    public CombatScreen(
            Drop game,
            Screen previousScreen,
            Fight fight
    ) {
        super(game);
        this.previousScreen = previousScreen;

        gameObjects.add(new CombatModePlayer(game, fight.player));
        gameObjects.add(new CombatModeEnemy(game, fight.enemy));
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();

        //fight.player.render(delta);
        //fight.enemy.render(delta);

        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(previousScreen);
            dispose();
        }
    }

    public static class Fight {
        private GameObject player;
        private GameObject enemy;

        public Fight(GameObject player, GameObject enemy) {
            this.player = player;
            this.enemy = enemy;
        }
    }
}
