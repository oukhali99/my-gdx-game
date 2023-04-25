package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;

public class NoUpdate extends BaseUpdater {
    public NoUpdate(Drop game) {
        super(game);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void update(BaseGameObject baseGameObject, float delta) {

    }

    @Override
    public void onCollision(BaseGameObject baseGameObject, BaseGameObject otherBaseGameObject) {

    }
}
