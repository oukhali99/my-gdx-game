package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class NoCollisions extends BaseCollider {
    public NoCollisions(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    @Override
    public Rectangle getArea() {
        return new Rectangle(0, 0, 0, 0);
    }
}
