package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;

public class RendererColorDecorator extends RendererBaseDecorator implements Renderer {
    private final Color color;

    public RendererColorDecorator(Renderer baseRenderer, Color color) {
        super(baseRenderer);
        this.color = color;
    }

    @Override
    public void render(float delta) {
        Color originalColor = getGame().batch.getColor().cpy();

        getGame().batch.setColor(color.cpy().mul(originalColor));
        super.render(delta);
        getGame().batch.setColor(originalColor);
    }
}
