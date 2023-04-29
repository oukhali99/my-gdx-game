package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;

public abstract class IntegerDependentTexture extends RendererBaseDecorator {
    public IntegerDependentTexture(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public abstract int getInteger();

    @Override
    public void render(float delta) {
        float healthFraction = (float) getInteger() / 100;

        Color color = new Color(getGame().batch.getColor());
        getGame().batch.setColor(new Color(1, healthFraction, healthFraction, 1).mul(color));
        super.render(delta);
        getGame().batch.setColor(color);
    }
}
