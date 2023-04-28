package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.mygdx.game.Drop;

import java.util.Random;

public class EnemyFactory {
    private static final Random RANDOM = new Random();

    public static Enemy createRandomEnemy(Drop game) {
        int randomInt = RANDOM.nextInt(3);

        Enemy enemy;

        switch (randomInt) {
            case 0:
                enemy = new WaterEnemy(game);
                break;
            case 1:
                enemy = new AlienEnemy(game);
                break;
            case 2:
                enemy = new AlienEnemy2(game);
                break;
            default:
                enemy = new WaterEnemy(game);
                break;
        }

        return enemy;
    }
}
