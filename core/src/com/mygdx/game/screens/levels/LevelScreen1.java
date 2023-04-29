package com.mygdx.game.screens.levels;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.characters.enemy.EnemyFactory;
import com.mygdx.game.gameobjects.powerups.Powerup;
import com.mygdx.game.gameobjects.powerups.PowerupFactory;

import java.util.Random;

public class LevelScreen1 extends LevelScreen {
    public LevelScreen1(Drop game, String warpEntryPoint) {
        super(game, warpEntryPoint);

        for (int i = 0; i < 10; i++) {
            GameObject enemy = EnemyFactory.createRandomEnemy(game);
            addGameObject(enemy);

            Random random = new Random();
            int max = 40;
            int min = 5;
            int x = random.nextInt(max - min + 1) + min;
            int y = random.nextInt(max - min + 1) + min;

            enemy.setPosition(16 * x, 16 * y);
        }

        for (int i = 0; i < 10; i++) {
            Powerup powerup = PowerupFactory.createPowerup(game);
            addGameObject(powerup);

            Random random = new Random();
            int max = 40;
            int min = 5;
            int x = random.nextInt(max - min + 1) + min;
            int y = random.nextInt(max - min + 1) + min;

            powerup.setPosition(16 * x, 16 * y);
        }
    }

    @Override
    public String getTilemapPath() {
        return "map/map2.tmx";
    }

    @Override
    public LevelScreen getLevelScreenDestinationForWarp(String destination, String warpExitName) {
        return new LevelScreen2(game, warpExitName);
    }
}
