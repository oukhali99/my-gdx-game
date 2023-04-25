package com.mygdx.game.gameobjects.combat;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.combat.combatactors.enemy.AlienEnemy;
import com.mygdx.game.gameobjects.combat.combatactors.enemy.AlienEnemy2;
import com.mygdx.game.gameobjects.combat.combatactors.enemy.WaterEnemy;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModeGameObject;
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

    public Attack createAttack(Drop game, Ability ability, CombatModeGameObject attacker, CombatModeGameObject target, CombatScreen.Fight fight) {
        int randomInt = RANDOM.nextInt(NUM_TYPES);

        Attack baseAttack = new Attack(game, ability, attacker, target, fight);

        switch (randomInt) {
            case 0:
                return baseAttack;
            case 1:
                return new MissedAttack(game, baseAttack);
            case 2:
                return new CriticalAttack(game, baseAttack);
            default:
                throw new IllegalStateException("Unexpected value: " + randomInt);
        }
    }
}
