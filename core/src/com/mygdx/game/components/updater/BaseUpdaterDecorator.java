package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class BaseUpdaterDecorator extends BaseUpdater {
    private BaseUpdater baseUpdater;

    public BaseUpdaterDecorator(BaseUpdater baseUpdater) {
        super(baseUpdater.getGame());
        this.baseUpdater = baseUpdater;
    }

    @Override
    public void destroy() {
        baseUpdater.destroy();
    }

    @Override
    public void update(GameObject gameObject, float delta) {
        baseUpdater.update(gameObject, delta);
    }

    @Override
    public void onCollision(GameObject gameObject, GameObject otherGameObject) {
        baseUpdater.onCollision(gameObject, otherGameObject);
    }
}
