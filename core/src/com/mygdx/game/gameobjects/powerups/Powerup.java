package com.mygdx.game.gameobjects.powerups;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.components.movement.Movement;
import com.mygdx.game.components.movement.MovementAvoidCollisionDecorator;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Powerup extends GameObject {
    private Movement movement;

    protected Powerup(Drop game) {
        super(game);

        getTransform().setScale(new Vector2(16, 16));

        setRenderer(new MyTexture(game, this, getTexturePath()));

        setCollider(new RectangleCollider(game, this));

        setMovement(new MovementAvoidCollisionDecorator(getMovement()));
    }

    protected abstract String getTexturePath();

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}
