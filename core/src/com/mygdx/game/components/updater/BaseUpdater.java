package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.BaseGameObject;

public abstract class BaseUpdater extends BaseComponent {
    public BaseUpdater(Drop game) {
        super(game);
    }
    public abstract void update(BaseGameObject baseGameObject, float delta);

    public abstract void onCollision(BaseGameObject baseGameObject, BaseGameObject otherBaseGameObject);
}
