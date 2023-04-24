package com.mygdx.game.gameobjects.combat.combatactors;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Movement;

public class Player extends CombatActor {
    public Player(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        Component movement = new Movement(game, 8);
        addComponent(movement);

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run() {
                Movement movementComponent = (Movement) getComponent(Movement.class);
                if (movementComponent != null) {
                    movementComponent.collided();
                }
            }
        });
        addComponent(collider);
    }

    @Override
    protected String getTexturePath() {
        return "bucket.png";
    }
}
