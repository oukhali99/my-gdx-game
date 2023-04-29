package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class ComponentBaseDecorator implements Component {
    private final Component baseComponent;

    public ComponentBaseDecorator(Component baseComponent) {
        this.baseComponent = baseComponent;
    }

    @Override
    public Drop getGame() {
        return baseComponent.getGame();
    }

    @Override
    public GameObject getGameObject() {
        return baseComponent.getGameObject();
    }

    @Override
    public void setGameObject(GameObject gameObject) {
        baseComponent.setGameObject(gameObject);
    }

    @Override
    public void destroy() {
        baseComponent.destroy();
    }
}
