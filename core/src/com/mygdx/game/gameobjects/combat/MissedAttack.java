package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;

public class MissedAttack extends Attack {
    public MissedAttack(Drop game, Attack baseAttack) {
        super(game, baseAttack.ability, baseAttack.attacker, baseAttack.target, baseAttack.fight);
    }

    @Override
    protected void translate(Vector2 scaledAttackVector) {
        super.translate(scaledAttackVector);
        transform.translate(0, 5);
    }

    @Override
    protected int getDamage() {
        return 0;
    }
}
