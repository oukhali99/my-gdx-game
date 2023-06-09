package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.screens.levels.LevelScreen1;

public class MainMenuScreen extends BaseScreen {

    public MainMenuScreen(final Drop game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new LevelScreen1(game));
            dispose();
        }
    }
}
