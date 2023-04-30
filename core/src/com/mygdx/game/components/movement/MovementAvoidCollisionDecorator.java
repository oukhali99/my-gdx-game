package com.mygdx.game.components.movement;

import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.attacks.Attack;

import java.util.Random;

public class MovementAvoidCollisionDecorator extends MovementBaseDecorator {
    public MovementAvoidCollisionDecorator(Movement baseUpdater) {
        super(baseUpdater);
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
        super.onCollision(otherGameObject);

        if (!(otherGameObject instanceof Attack)) {
            Random random = new Random();
            boolean xPositive = random.nextFloat() < 0.5f;
            boolean yPositive = random.nextFloat() < 0.5f;
            getGameObject().getTransform().translate(xPositive ? 16 : -16, yPositive ? 16 : -16);
        }
    }
}
