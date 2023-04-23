package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Game;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Movement;
import com.mygdx.game.components.Texture;

public class Player extends GameObject {
    public Player(Drop game) {
        super(game);
    }

    @Override
    protected void initialize() {
        super.initialize();

        setPosition(400, 350);
        setScale(16, 16);

        addComponent(new Movement(game, 100));
        addComponent(new Collider(game) {
            @Override
            public void onCollision(GameObject otherObject) {
                System.out.println("Collided with " + gameObject);
            }
        });
        addComponent(new Texture(game, "bucket.png"));
    }
}
