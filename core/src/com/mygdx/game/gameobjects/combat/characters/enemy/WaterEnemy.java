package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.Drop;

public class WaterEnemy extends Enemy {
    public WaterEnemy(Drop game) {
        super(game);
    }

    @Override
    public String getTexturePath() {
        return "droplet.png";
    }
}
