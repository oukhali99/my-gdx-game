package com.mygdx.game.gameobjects.combat.enemy;

import com.mygdx.game.gameobjects.GameObjectDecorator;

public class EnemyDecorator extends GameObjectDecorator implements Enemy {
    private Enemy enemy;

    public EnemyDecorator(Enemy enemy) {
        super(enemy);
        this.enemy = enemy;
    }
}
