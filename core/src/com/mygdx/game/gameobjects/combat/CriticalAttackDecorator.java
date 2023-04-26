package com.mygdx.game.gameobjects.combat;

import com.mygdx.game.gameobjects.GameObjectDecorator;
import com.mygdx.game.screens.CombatScreen;

public class CriticalAttackDecorator extends GameObjectDecorator implements Attack {
    private Attack attack;

    public CriticalAttackDecorator(Attack attack) {
        super(attack);
        this.attack = attack;
    }

    @Override
    public CombatScreen.Fight getFight() {
        return attack.getFight();
    }
}
