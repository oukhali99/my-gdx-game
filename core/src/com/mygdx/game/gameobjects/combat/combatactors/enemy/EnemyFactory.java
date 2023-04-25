package com.mygdx.game.gameobjects.combat.combatactors.enemy;

import com.mygdx.game.Drop;

import java.util.Random;

public class EnemyFactory {
    private static final Random RANDOM = new Random();
    private static final int NUM_ENEMY_TYPES = 3;

    public static Enemy createRandomEnemy(Drop game) {
        int randomInt = RANDOM.nextInt(NUM_ENEMY_TYPES);

        switch (randomInt) {
            case 0:
                return new WaterEnemy(game);
            case 1:
                return new AlienEnemy(game);
            case 2:
                return new AlienEnemy2(game);
            default:
                throw new IllegalStateException("Unexpected value: " + randomInt);
        }
    }
}
