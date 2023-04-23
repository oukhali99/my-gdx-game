package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Game;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Movement;

public class Player extends GameObject {
    public Player(Drop game) {
        super(game);
    }

    @Override
    protected void initialize() {
        super.initialize();

        setPosition(400, 350);
        setScale(16, 16);

        addComponent(new Movement(100));
    }

    @Override
    protected String getTexturePath() {
        return "bucket.png";
    }
}
