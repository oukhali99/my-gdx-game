package com.mygdx.game.gameobjects.combat.combatactors.enemy;

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
