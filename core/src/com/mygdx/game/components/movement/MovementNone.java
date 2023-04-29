package com.mygdx.game.components.movement;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class MovementNone extends BaseMovement {
    public MovementNone(Drop game, GameObject gameObject, float speed) {
        super(game, gameObject, speed);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
    }
}
