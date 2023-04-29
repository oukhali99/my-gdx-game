package com.mygdx.game.components.updater;

import com.mygdx.game.gameobjects.GameObject;

public class UpdaterBaseDecorator extends Updater {
    private Updater baseUpdater;

    public UpdaterBaseDecorator(Updater baseUpdater) {
        super(baseUpdater.getGame(), baseUpdater.getGameObject());
        this.baseUpdater = baseUpdater;
    }

    @Override
    public void destroy() {
        baseUpdater.destroy();
    }

    @Override
    public void setGameObject(GameObject gameObject) {
        super.setGameObject(gameObject);
        baseUpdater.setGameObject(gameObject);
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
