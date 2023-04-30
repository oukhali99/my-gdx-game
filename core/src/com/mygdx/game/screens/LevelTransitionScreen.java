package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Drop;

public class LevelTransitionScreen extends BaseScreen {
    private static float WAIT_TIME_SECONDS = 2;
    private float waitedTime;
    private final Screen nextScreen;
    private final Game game;

    public LevelTransitionScreen(Drop game, Screen nextScreen) {
        super(game);
        this.waitedTime = 0;
        this.nextScreen = nextScreen;
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (waitedTime > WAIT_TIME_SECONDS) {
            game.setScreen(nextScreen);
        }
        waitedTime += delta;
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
