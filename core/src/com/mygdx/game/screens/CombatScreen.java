package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class CombatScreen extends BaseScreen {
    private Screen previousScreen;
    private Fight fight;
    protected OrthographicCamera camera;

    public CombatScreen(
            Drop game,
            Screen previousScreen,
            Fight fight
    ) {
        super(game);
        this.previousScreen = previousScreen;
        this.fight = fight;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        fight.player.render(delta);
        fight.enemy.render(delta);

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
