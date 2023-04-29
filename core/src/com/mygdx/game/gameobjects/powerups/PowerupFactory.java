package com.mygdx.game.gameobjects.powerups;

import com.mygdx.game.Drop;

import java.util.Random;

public class PowerupFactory {
    private static final Random RANDOM = new Random();

    public static Powerup createPowerup(Drop game) {
        int randInt = RANDOM.nextInt(2);

        Powerup powerup;

        switch (randInt) {
            case 0:
                powerup = new Health(game);
                break;
            case 1:
                powerup = new Speed(game);
                break;
            default:
                powerup = new Health(game);
        }

        return powerup;
    }
}
