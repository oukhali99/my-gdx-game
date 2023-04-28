package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Renderer extends BaseComponent {
    public Renderer(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    public abstract void render(float delta);
}
