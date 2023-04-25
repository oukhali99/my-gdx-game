package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

public class NoUpdate extends BaseUpdater {
    public NoUpdate(Drop game) {
        super(game);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void update(GameObject baseGameObject, float delta) {

    }

    @Override
    public void onCollision(GameObject baseGameObject, GameObject otherBaseGameObject) {

    }
}
