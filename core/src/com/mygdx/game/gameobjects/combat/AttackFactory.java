package com.mygdx.game.gameobjects.combat;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
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

    public Attack createAttack(Drop game, Ability ability, GameObject attacker, GameObject target, CombatScreen.Fight fight) {
        int randomInt = RANDOM.nextInt(NUM_TYPES);

        Attack baseAttack = new Attack(game, ability, attacker, target, fight);

        switch (randomInt) {
            case 0:
                return baseAttack;
            case 1:
                return baseAttack;
            case 2:
                return baseAttack;
            default:
                throw new IllegalStateException("Unexpected value: " + randomInt);
        }
    }
}
