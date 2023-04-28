package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseComponent implements Component {
    protected final Drop game;
    public final GameObject gameObject;

    public BaseComponent(Drop game, GameObject gameObject) {
        this.game = game;
        this.gameObject = gameObject;
    }

    public BaseComponent(BaseComponent baseComponent) {
        this.game = baseComponent.game;
        this.gameObject = baseComponent.gameObject;
    }

    public Drop getGame() {
        return game;
    }

    @Override
    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseComponentDecorator) {
            BaseComponentDecorator baseComponentDecorator = (BaseComponentDecorator) obj;
            if (baseComponentDecorator.equals(this)) {
                return true;
            }
        }

        return super.equals(obj);
    }
}
