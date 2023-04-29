package com.mygdx.game.gameobjects.powerups;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Powerup extends GameObject {
    protected Powerup(Drop game) {
        super(game);

        getTransform().setScale(new Vector2(16, 16));

        setRenderer(new MyTexture(game, this, getTexturePath()));
    }

    protected abstract String getTexturePath();
}
