package com.mygdx.game.components.renderer;

import com.mygdx.game.gameobjects.GameObject;

public class RendererBaseDecorator extends Renderer {
    protected Renderer baseRenderer;

    public RendererBaseDecorator(Renderer baseRenderer) {
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

    @Override
    public void setGameObject(GameObject gameObject) {
        super.setGameObject(gameObject);
        baseRenderer.setGameObject(gameObject);
    }

    public Renderer getBaseComponent() {
        return baseRenderer;
    }
}
