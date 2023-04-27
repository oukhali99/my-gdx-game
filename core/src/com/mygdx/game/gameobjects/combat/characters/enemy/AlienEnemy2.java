package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.Drop;

public class AlienEnemy2 extends BaseEnemy {
    public AlienEnemy2(Drop game) {
        super(game);
        setScale(32, 32);
    }

    @Override
    public String getTexturePath() {
        return "alien2.png";
    }
}
