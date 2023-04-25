package com.mygdx.game.components.renderer;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class RendererDecorator extends Renderer {
    protected Renderer baseRenderer;

    public RendererDecorator(Renderer baseRenderer) {
        super(baseRenderer.getGame());
        this.baseRenderer = baseRenderer;
    }

    @Override
    public void destroy() {
        baseRenderer.destroy();
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        baseRenderer.render(gameObject, delta);
    }
}
