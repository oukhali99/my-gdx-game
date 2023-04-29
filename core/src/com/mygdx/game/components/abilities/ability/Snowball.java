package com.mygdx.game.components.abilities.ability;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.utils.SpriteSheet;

public class Snowball extends BaseAbility {
    public Snowball(Drop game) {
        super(game, "Snowball", 8);
    }

    @Override
    protected SpriteSheet getSpriteSheet() {
        return new SpriteSheet("snowball.png", 1, 1, new Vector2(8, 8), false);
    }
}
