package com.mygdx.game.gameobjects.combat.enemy;

import com.mygdx.game.Drop;

public class WaterEnemy extends Enemy {
    public WaterEnemy(Drop game) {
        super(game);
    }

    @Override
    protected String getTexturePath() {
        return "droplet.png";
    }
}
