package com.mygdx.game.gameobjects.enemy;

import com.mygdx.game.Drop;

public class FireEnemy extends Enemy {
    public FireEnemy(Drop game) {
        super(game);
        setScale(32, 32);
    }

    @Override
    protected String getTexturePath() {
        return "alien.png";
    }
}
