package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseComponent implements Component {
    protected final Drop game;
    protected GameObject gameObject;

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

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void destroy() {
    }

    public void resize(int width, int height) {
    }
}
