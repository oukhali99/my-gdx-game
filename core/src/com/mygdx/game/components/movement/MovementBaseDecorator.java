package com.mygdx.game.components.movement;

import com.mygdx.game.components.ComponentBaseDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class MovementBaseDecorator extends ComponentBaseDecorator implements Movement {
    private final Movement baseUpdater;

    public MovementBaseDecorator(Movement baseUpdater) {
        super(baseUpdater);
        this.baseUpdater = baseUpdater;
    }

    @Override
    public void update(float delta) {
        baseUpdater.update(delta);
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
        baseUpdater.onCollision(otherGameObject);
    }

    @Override
    public void setSpeed(float speed) {
        baseUpdater.setSpeed(speed);
    }

    @Override
    public float getSpeed() {
        return baseUpdater.getSpeed();
    }

    @Override
    public void applySpeedBoost(float multiplier, float duration) {
        baseUpdater.applySpeedBoost(multiplier, duration);
    }
}
