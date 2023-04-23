package com.mygdx.game.gameobjects.enemy;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Texture;
import com.mygdx.game.gameobjects.GameObject;

public class Enemy extends GameObject {
    public Enemy(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        addComponent(new Texture(game, getTexturePath()));
    }

    protected String getTexturePath() {
        return "droplet.png";
    }
}
