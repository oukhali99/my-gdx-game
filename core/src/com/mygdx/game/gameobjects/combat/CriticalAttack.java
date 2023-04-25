package com.mygdx.game.gameobjects.combat;

import com.mygdx.game.Drop;

public class CriticalAttack extends Attack {
    private Attack baseAttack;

    public CriticalAttack(Drop game, Attack baseAttack) {
        super(game, baseAttack.ability, baseAttack.attacker, baseAttack.target, baseAttack.fight);
        this.baseAttack = baseAttack;
    }

    @Override
    protected int getDamage() {
        return super.getDamage() * 2;
    }
}
