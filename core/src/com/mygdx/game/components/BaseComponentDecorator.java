package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class BaseComponentDecorator implements Component {
    private Component baseComponent;

    public BaseComponentDecorator(Component baseComponent) {
        this.baseComponent = baseComponent;
    }

    @Override
    public void destroy() {
        baseComponent.destroy();
    }

    public Drop getGame() {
        return baseComponent.getGame();
    }

    @Override
    public GameObject getGameObject() {
        return baseComponent.getGameObject();
    }

    @Override
    public boolean equals(Object obj) {
        if (baseComponent.equals(obj)) {
            return true;
        }

        return super.equals(obj);
    }
}
