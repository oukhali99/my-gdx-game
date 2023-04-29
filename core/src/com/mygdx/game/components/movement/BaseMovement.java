package com.mygdx.game.components.movement;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseMovement extends BaseComponent implements Movement {
    private float speed;
    private final List<SpeedBoost> speedBoosts;

    public BaseMovement(Drop game, GameObject gameObject, float speed) {
        super(game, gameObject);
        this.speed = speed;
        this.speedBoosts = new LinkedList<>();
    }

    @Override
    public void update(float delta) {
        if (!speedBoosts.isEmpty()) {
            SpeedBoost activeSpeedBoost = speedBoosts.get(0);

            setSpeed(activeSpeedBoost.initialSpeed * activeSpeedBoost.multiplier);

            activeSpeedBoost.duration -= delta;
            if (activeSpeedBoost.duration <= 0) {
                speedBoosts.remove(activeSpeedBoost);
                setSpeed(activeSpeedBoost.initialSpeed);
            }
        }
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void applySpeedBoost(float multiplier, float duration) {
        SpeedBoost speedBoost = new SpeedBoost(speed, multiplier, duration);
        speedBoosts.add(0, speedBoost);
    }

    private static class SpeedBoost {
        private final float initialSpeed;
        private final float multiplier;
        private float duration;

        public SpeedBoost(float initialSpeed, float multiplier, float duration) {
            this.initialSpeed = initialSpeed;
            this.multiplier = multiplier;
            this.duration = duration;
        }
    }
}
