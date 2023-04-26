package com.mygdx.game.gameobjects.combat.enemy;

import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.InvincibleDecorator;

import java.util.Random;

public class EnemyFactory {
    private static final Random RANDOM = new Random();

    public static Enemy createRandomEnemy(Drop game) {
        int randomInt = RANDOM.nextInt(4);

        switch (randomInt) {
            case 0:
                return new WaterEnemy(game);
            case 1:
                return new AlienEnemy(game);
            case 2:
                return new AlienEnemy2(game);
            case 3:
                Enemy enemy = new WaterEnemy(game);
                enemy.setAbilities(new InvincibleDecorator(enemy.getAbilities()));
                return enemy;
            default:
                throw new IllegalStateException("Unexpected value: " + randomInt);
        }
    }
}
