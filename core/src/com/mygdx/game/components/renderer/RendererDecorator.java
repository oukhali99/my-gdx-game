package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponentDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class RendererDecorator extends BaseComponentDecorator implements Renderer {
    protected Renderer baseRenderer;

    public RendererDecorator(Renderer baseRenderer) {
        super(baseRenderer);
        this.baseRenderer = baseRenderer;
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        baseRenderer.render(gameObject, delta);
    }
}
