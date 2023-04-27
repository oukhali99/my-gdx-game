package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.InvincibleDecorator;

public class InvincibleEnemyDecorator extends BaseEnemyDecorator {
    public InvincibleEnemyDecorator(Enemy enemy) {
        super(enemy);
    }

    @Override
    public Abilities getAbilities() {
        return new InvincibleDecorator(super.getAbilities());
    }
}
