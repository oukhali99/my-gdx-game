package com.mygdx.game.components.renderer;

import com.mygdx.game.gameobjects.BaseGameObject;

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
    public void render(BaseGameObject baseGameObject, float delta) {
        baseRenderer.render(baseGameObject, delta);
    }
}
