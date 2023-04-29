package com.mygdx.game.components.updater;

import com.mygdx.game.components.ComponentBaseDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class UpdaterBaseDecorator extends ComponentBaseDecorator implements Updater {
    private Updater baseUpdater;

    public UpdaterBaseDecorator(Updater baseUpdater) {
        super(baseUpdater);
        this.baseUpdater = baseUpdater;
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
