package com.mygdx.game.gameobjects;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Movement;
import com.mygdx.game.components.Texture;
import com.mygdx.game.utils.Logger;

public class Player extends GameObject {
    public Player(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        Component movement = new Movement(game, 8);
        addComponent(movement);

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run(GameObject otherObject) {
                Logger.log("Collided with " + otherObject);

                Movement movementComponent = (Movement) getComponent(Movement.class);
                if (movementComponent != null) {
                    movementComponent.collided();
                }
            }
        });
        addComponent(collider);

        addComponent(new Texture(game, "bucket.png"));
    }
}
