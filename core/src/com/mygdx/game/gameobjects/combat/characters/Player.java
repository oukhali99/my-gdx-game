package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.movement.MovementWASDDecorator;

public class Player extends Character {
    public Player(Drop game) {
        super(game);

        setMovement(new MovementWASDDecorator(getMovement()));
    }

    public Player(Player player) {
        super(player);
    }

    public String getTexturePath() {
        return "bucket.png";
    }
}
