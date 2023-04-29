package com.mygdx.game.components.renderer;

import com.mygdx.game.components.ComponentBaseDecorator;

public class RendererBaseDecorator extends ComponentBaseDecorator implements Renderer {
    protected Renderer baseRenderer;

    public RendererBaseDecorator(Renderer baseRenderer) {
        super(baseRenderer);
        this.baseRenderer = baseRenderer;
    }

    @Override
    public void render(float delta) {
        baseRenderer.render(delta);
    }
}
