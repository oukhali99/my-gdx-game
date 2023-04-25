package com.mygdx.game.components.updater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobjects.BaseGameObject;

public class WASDMovement extends BaseUpdaterDecorator {
    private static final int MOVE_DISTANCE = 16;
    private final float speed;
    private Integer currentKey;
    private float fillCooldown;
    private Vector2 lastPosition;

    public WASDMovement(BaseUpdater baseUpdater, float speed) {
        super(baseUpdater);
        this.speed = speed;
        this.fillCooldown = 1 / speed;
    }

    @Override
    public void update(BaseGameObject baseGameObject, float delta) {
        super.update(baseGameObject, delta);
        Vector2 position = baseGameObject.getTransform().getPosition();
        lastPosition = new Vector2(position);
        float dx = 0, dy = 0;

        if (currentKey == null || !Gdx.input.isKeyPressed(currentKey)) {
            if (currentKey != null && !Gdx.input.isKeyPressed(currentKey)) {
                currentKey = null;
            }

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                currentKey = Input.Keys.A;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                currentKey = Input.Keys.D;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                currentKey = Input.Keys.W;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                currentKey = Input.Keys.S;
            }
        }
        else if (currentKey != null && fillCooldown >= 1 / speed) {
            switch (currentKey) {
                case (Input.Keys.A):
                    position.x -= MOVE_DISTANCE;
                    break;
                case (Input.Keys.D):
                    position.x += MOVE_DISTANCE;
                    break;
                case (Input.Keys.W):
                    position.y += MOVE_DISTANCE;
                    break;
                case (Input.Keys.S):
                    position.y -= MOVE_DISTANCE;
                    break;
                default:
                    break;
            }
            baseGameObject.setPosition(position);

            fillCooldown = 0;
        }

        fillCooldown += delta;
    }

    @Override
    public void onCollision(BaseGameObject baseGameObject, BaseGameObject otherBaseGameObject) {
        super.onCollision(baseGameObject, otherBaseGameObject);
        baseGameObject.setPosition(lastPosition);
    }
}
