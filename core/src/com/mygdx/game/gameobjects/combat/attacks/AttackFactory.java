package com.mygdx.game.gameobjects.combat.attacks;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.combat.characters.Character;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.screens.CombatScreen;

import java.util.Random;

public class AttackFactory {
    private static final Random RANDOM = new Random();
    private static final int NUM_TYPES = 3;
    private static AttackFactory instance;

    public static AttackFactory getInstance() {
        if (instance == null) {
            instance = new AttackFactory();
        }

        return instance;
    }

    public Attack createAttack(Drop game, Ability ability, Character attacker, Character target, CombatScreen.Fight fight) {
        int randomInt = RANDOM.nextInt(NUM_TYPES);

        Attack baseAttack = new BaseAttack(game, ability, attacker, target, fight);

        if (RANDOM.nextFloat() < 0.2f) {
            baseAttack = new CriticalAttackDecorator(baseAttack);
        }

        return baseAttack;
    }
}
