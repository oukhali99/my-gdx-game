package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.mygdx.game.level.Level;
import com.mygdx.game.level.Level1;

public class GameScreen implements Screen {
    private final Drop game;
    private Level currentLevel;

    public GameScreen(final Drop game) {
        this.game = game;
        this.currentLevel = new Level1(game);
    }

    @Override
    public void render(float delta) {
        currentLevel.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        currentLevel.resize(width, height);
    }

    @Override
    public void show() {
        currentLevel.show();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        currentLevel.dispose();
    }
}
