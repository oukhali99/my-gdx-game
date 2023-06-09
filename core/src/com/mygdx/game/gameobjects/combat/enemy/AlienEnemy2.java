package com.mygdx.game.gameobjects.combat.enemy;

import com.mygdx.game.Drop;

public class AlienEnemy2 extends Enemy {
    public AlienEnemy2(Drop game) {
        super(game);
        setScale(32, 32);
    }

    @Override
    protected String getTexturePath() {
        return "alien2.png";
    }
}
