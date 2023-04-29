package com.mygdx.game.gameobjects.powerups;

import com.mygdx.game.Drop;

public class PowerupFactory {
    public static Health createPowerup(Drop game) {
        Health health = new Health(game);
        return health;
    }
}
