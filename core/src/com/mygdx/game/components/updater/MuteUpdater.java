package com.mygdx.game.components.updater;

public class MuteUpdater extends UpdaterBaseDecorator {
    public MuteUpdater(Updater baseUpdater) {
        super(baseUpdater);
    }

    @Override
    public void update(float delta) {
        //super.update(gameObject, delta);
    }
}
