package com.mygdx.game.gameobjects.combat.enemy;

import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.abilities.InvincibleDecorator;

public class InvincibleEnemyDecorator extends EnemyDecorator {
    public InvincibleEnemyDecorator(Enemy enemy) {
        super(enemy);
    }

    @Override
    public BaseAbilities getAbilities() {
        return new InvincibleDecorator(super.getAbilities());
    }
}
