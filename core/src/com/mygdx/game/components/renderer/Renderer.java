package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.BaseGameObject;

public abstract class Renderer extends BaseComponent {
    public Renderer(Drop game) {
        super(game);
    }

    public Renderer(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public abstract void render(BaseGameObject baseGameObject, float delta);
}
