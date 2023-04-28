package com.mygdx.game.components.updater;

import com.mygdx.game.gameobjects.GameObject;

public class MuteUpdater extends BaseUpdaterDecorator {
    public MuteUpdater(Updater baseUpdater) {
        super(baseUpdater);
    }

    @Override
    public void update(float delta) {
        //super.update(gameObject, delta);
    }
}
