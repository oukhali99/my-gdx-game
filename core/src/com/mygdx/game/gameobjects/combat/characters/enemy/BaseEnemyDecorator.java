package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.gameobjects.combat.characters.BaseCharacterDecorator;

public class BaseEnemyDecorator extends BaseCharacterDecorator implements Enemy {
    private Enemy enemy;

    public BaseEnemyDecorator(Enemy enemy) {
        super(enemy);
        this.enemy = enemy;
    }
}
