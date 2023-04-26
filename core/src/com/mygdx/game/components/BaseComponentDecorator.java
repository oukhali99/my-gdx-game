package com.mygdx.game.components;

import com.mygdx.game.Drop;

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
}
