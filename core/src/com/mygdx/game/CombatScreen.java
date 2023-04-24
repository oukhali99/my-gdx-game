package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.gameobjects.GameObject;
import sun.security.x509.OtherName;

public class CombatScreen implements Screen {
    private final Drop game;
    private Screen previousScreen;
    private GameObject player;
    private GameObject enemy;
    protected OrthographicCamera camera;

    public CombatScreen(
            Drop game,
            Screen previousScreen,
            GameObject player,
            GameObject enemy
    ) {
        this.game = game;
        this.previousScreen = previousScreen;
        this.player = player;
        this.enemy = enemy;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        player.render(delta);
        enemy.render(delta);

        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(previousScreen);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
