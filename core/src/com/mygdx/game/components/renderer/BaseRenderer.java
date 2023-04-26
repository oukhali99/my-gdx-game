package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseRenderer extends BaseComponent implements Renderer {
    public BaseRenderer(Drop game) {
        super(game);
    }
}
