package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Component {
    protected final Drop game;
    protected GameObject gameObject;

    public Component(Drop game) {
        this.game = game;
        initialize();
    }

    public void initialize() {
    }

    public void render(float delta) {
    }

    public void update(float delta) {
    }

    public void postUpdate(float delta) {
    }

    public void attachToGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void destroy() {
    }

    public void postPostUpdate() {
    }
}
