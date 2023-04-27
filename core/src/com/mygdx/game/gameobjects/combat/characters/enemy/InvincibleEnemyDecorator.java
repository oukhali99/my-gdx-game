package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.utils.Logger;

public class InvincibleEnemyDecorator extends BaseEnemyDecorator {
    public InvincibleEnemyDecorator(Enemy enemy) {
        super(enemy);
    }


    @Override
    public void takeDamage(int damage) {
        Logger.log(this + " is invincible!!!");
        //super.takeDamage(damage);
    }
}
