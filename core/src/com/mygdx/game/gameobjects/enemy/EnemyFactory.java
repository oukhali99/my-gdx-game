package com.mygdx.game.gameobjects.enemy;

import com.mygdx.game.Drop;

import java.util.Random;

public class EnemyFactory {
    private static final Random RANDOM = new Random();
    private static final int NUM_ENEMY_TYPES = 3;

    public static Enemy createRandomEnemy(Drop game) {
        int randomInt = RANDOM.nextInt(NUM_ENEMY_TYPES);

        switch (randomInt) {
            case 0:
                return new Enemy(game);
            case 1:
                return new FireEnemy(game);
            case 2:
                return new Enemy(game);
            default:
                throw new IllegalStateException("Unexpected value: " + randomInt);
        }
    }
}
