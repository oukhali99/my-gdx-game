package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.Drop;

public class AlienEnemy extends Enemy {
    public AlienEnemy(Drop game) {
        super(game);
        setScale(32, 32);
    }

    @Override
    public String getTexturePath() {
        return "alien.png";
    }
}
