package com.mygdx.game.components.updater;

import com.mygdx.game.gameobjects.GameObject;

public class BaseUpdaterDecorator extends Updater {
    private Updater baseUpdater;

    public BaseUpdaterDecorator(Updater baseUpdater) {
        super(baseUpdater.getGame(), baseUpdater.getGameObject());
        this.baseUpdater = baseUpdater;
    }

    @Override
    public void destroy() {
        baseUpdater.destroy();
    }

    @Override
    public void update(float delta) {
        baseUpdater.update(delta);
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
        baseUpdater.onCollision(otherGameObject);
    }
}
