package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.Drop;

public class AlienEnemy extends BaseEnemy {
    public AlienEnemy(Drop game) {
        super(game);
        setScale(32, 32);
    }

    @Override
    protected String getTexturePath() {
        return "alien.png";
    }
}
