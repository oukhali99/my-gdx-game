package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Transform;

public abstract class GameObject {
    protected final Drop game;
    protected Transform transform;
    protected Texture texture;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform();

        initialize();
    }

    protected void initialize() {
        texture = new Texture(Gdx.files.internal(getTexturePath()));
    }

    public void render(float delta) {
        game.batch.draw(texture, transform.getPosition().x, transform.getPosition().y);
    }

    public void update(float delta) {
    }

    protected abstract String getTexturePath();

    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }
}
