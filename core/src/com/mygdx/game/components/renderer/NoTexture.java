package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

public class NoTexture extends Renderer {
    public NoTexture(Drop game) {
        super(game);
    }

    @Override
    public void render(GameObject baseGameObject, float delta) {

    }

    @Override
    public void destroy() {

    }
}
