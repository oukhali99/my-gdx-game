package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.screens.MainMenuScreen;

public class Drop extends Game {
	public SpriteBatch batch;
	public BitmapFont font;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render(); // important!
	}

	@Override
	public BaseScreen getScreen() {
		return (BaseScreen) super.getScreen();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();
		getScreen().dispose();
	}
}
