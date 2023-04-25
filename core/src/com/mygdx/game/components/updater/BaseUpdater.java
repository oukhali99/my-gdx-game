package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseUpdater extends BaseComponent {
    public BaseUpdater(Drop game) {
        super(game);
    }
    public abstract void update(GameObject baseGameObject, float delta);

    public abstract void onCollision(GameObject baseGameObject, GameObject otherBaseGameObject);
}
