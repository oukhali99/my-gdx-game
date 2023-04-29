package com.mygdx.game.components.abilities.ability;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.utils.SpriteSheet;

public class Fireball extends BaseAbility {
    public Fireball(Drop game) {
        super(game, "Fireball", 10);
    }

    @Override
    protected SpriteSheet getSpriteSheet() {
        return new SpriteSheet("fireball.png", 2, 2, new Vector2(116, 32), true);
    }
}
