package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseComponent implements Component {
    protected final Drop game;

    public BaseComponent(Drop game) {
        this.game = game;
    }

    public BaseComponent(BaseComponent baseComponent) {
        this.game = baseComponent.game;
    }

    public Drop getGame() {
        return game;
    }
}
