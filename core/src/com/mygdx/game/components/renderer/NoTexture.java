package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class NoTexture extends Renderer {
    public NoTexture(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    @Override
    public void render(float delta) {
    }
}
