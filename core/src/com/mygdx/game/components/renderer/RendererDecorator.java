package com.mygdx.game.components.renderer;

import com.mygdx.game.components.BaseComponentDecorator;

public class RendererDecorator extends BaseComponentDecorator implements Renderer {
    protected Renderer baseRenderer;

    public RendererDecorator(Renderer baseRenderer) {
        super(baseRenderer);
        this.baseRenderer = baseRenderer;
    }

    @Override
    public void render(float delta) {
        baseRenderer.render(delta);
    }
}
