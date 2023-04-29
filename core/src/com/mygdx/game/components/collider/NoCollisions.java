package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public class NoCollisions extends BaseCollider {
    public NoCollisions(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
    }

    @Override
    public Rectangle getArea() {
        return new Rectangle(0, 0, 0, 0);
    }
}
