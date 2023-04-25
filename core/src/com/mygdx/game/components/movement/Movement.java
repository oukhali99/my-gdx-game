package com.mygdx.game.components.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Component;

public class Movement extends BaseComponent implements Component {
    private static final int MOVE_DISTANCE = 16;
    private final float speed;
    private Integer currentKey;
    private float fillCooldown;
    private Vector2 lastPosition;

    public Movement(Drop game, float speed) {
        super(game);
        this.speed = speed;
        this.fillCooldown = 1 / speed;
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void update(float delta) {
        Vector2 position = gameObject.getTransform().getPosition();
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
            gameObject.setPosition(position);

            fillCooldown = 0;
        }

        fillCooldown += delta;
    }

    @Override
    public void postUpdate(float delta) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void postPostUpdate(float delta) {

    }

    public void collided() {
        gameObject.setPosition(lastPosition.x, lastPosition.y);
    }
}