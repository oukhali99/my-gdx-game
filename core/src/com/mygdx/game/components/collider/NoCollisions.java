package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public class NoCollisions extends BaseCollider {
    public NoCollisions(Drop game) {
        super(game);
    }

    @Override
    public void lookForCollisions(float delta, List<GameObject> gameObjects, GameObject gameObject) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void handleCollisionsThisFrame(GameObject gameObject, float delta) {

    }

    @Override
    public Rectangle getArea(GameObject gameObject) {
        return new Rectangle(0, 0, 0, 0);
    }
}
