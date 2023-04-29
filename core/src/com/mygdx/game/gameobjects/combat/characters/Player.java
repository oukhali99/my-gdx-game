package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.updater.WASDMovement;

public class Player extends Character {
    public Player(Drop game) {
        super(game);

        setUpdater(new WASDMovement(getUpdater(), 128));
    }

    public Player(Player player) {
        super(player);
    }

    public String getTexturePath() {
        return "bucket.png";
    }
}
