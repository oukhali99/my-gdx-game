package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;

public class Movement extends Component {
    private final float speed;

    public Movement(Drop game, float speed) {
        super(game);
        this.speed = speed;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        Vector2 position = gameObject.getTransform().getPosition();
        float dx = 0, dy = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            dx -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            dx += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            dy += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            dy -= speed;
        }
        position.x += dx * delta;
        position.y += dy * delta;
    }
}
