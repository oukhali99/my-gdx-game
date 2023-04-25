package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;

public class NoTexture extends Renderer {
    public NoTexture(Drop game) {
        super(game);
    }

    @Override
    public void render(BaseGameObject baseGameObject, float delta) {

    }

    @Override
    public void destroy() {

    }
}
