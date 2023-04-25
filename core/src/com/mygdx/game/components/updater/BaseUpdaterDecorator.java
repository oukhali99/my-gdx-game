package com.mygdx.game.components.updater;

import com.mygdx.game.gameobjects.BaseGameObject;
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
    public void update(GameObject baseGameObject, float delta) {
        baseUpdater.update(baseGameObject, delta);
    }

    @Override
    public void onCollision(GameObject baseGameObject, GameObject otherBaseGameObject) {
        baseUpdater.onCollision(baseGameObject, otherBaseGameObject);
    }
}
