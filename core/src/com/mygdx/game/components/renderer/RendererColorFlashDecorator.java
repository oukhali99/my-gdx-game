package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;

public class RendererColorFlashDecorator extends RendererBaseDecorator {
    private Color color;
    private float interval;
    private float countUp;

    public RendererColorFlashDecorator(Renderer baseRenderer, Color color, float interval) {
        super(baseRenderer);
        this.color = color;
        this.interval = interval;
        this.countUp = 0;
    }

    @Override
    public void render(float delta) {
        Color originalColor = getGame().batch.getColor().cpy();

        if (countUp > interval) {
            getGame().batch.setColor(color.cpy().mul(originalColor));

            if (countUp > 2 * interval) {
                countUp = 0;
            }
        }
        super.render(delta);
        getGame().batch.setColor(originalColor);

        countUp += delta;
    }
}
