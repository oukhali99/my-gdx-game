package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Updater extends BaseComponent {
    public Updater(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    public abstract void update(float delta);

    public abstract void onCollision(GameObject otherGameObject);
}
