package com.mygdx.game.gameobjects.combat.combatactors;

import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.movement.Movement;
import com.mygdx.game.gameobjects.GameObject;

public class Player extends CombatActor {
    public Player(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        BaseComponent movement = new Movement(game, 8);
        addComponent(movement);

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run(GameObject otherGameObject) {
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
