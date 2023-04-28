package com.mygdx.game.components.renderer;

public class RendererDecorator extends Renderer {
    protected Renderer baseRenderer;

    public RendererDecorator(Renderer baseRenderer) {
        super(baseRenderer.getGame(), baseRenderer.getGameObject());
        this.baseRenderer = baseRenderer;
    }

    @Override
    public void render(float delta) {
        baseRenderer.render(delta);
    }

    @Override
    public void destroy() {
        baseRenderer.destroy();
    }
}
