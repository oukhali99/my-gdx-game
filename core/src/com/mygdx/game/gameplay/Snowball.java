package com.mygdx.game.gameplay;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.utils.SpriteSheet;

public class Snowball extends Ability {
    public Snowball(Drop game) {
        super(game, "Snowball", 8);
    }

    @Override
    protected SpriteSheet getSpriteSheet() {
        return new SpriteSheet("bucket.png", 1, 1, new Vector2(32, 32), false);
    }
}
