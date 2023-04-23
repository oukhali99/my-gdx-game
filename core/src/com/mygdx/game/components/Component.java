package com.mygdx.game.components;

import com.mygdx.game.GameObject;

public abstract class Component {
    protected GameObject gameObject;

    public void update(float delta) {
    }

    public void attachToGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void destroy() {
    }

    public void onGameObjectChanged() {
    }
}
