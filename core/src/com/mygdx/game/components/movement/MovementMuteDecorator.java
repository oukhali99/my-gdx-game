package com.mygdx.game.components.movement;

public class MovementMuteDecorator extends MovementBaseDecorator {
    public MovementMuteDecorator(Movement baseUpdater) {
        super(baseUpdater);
    }

    @Override
    public void update(float delta) {
        //super.update(gameObject, delta);
    }
}
