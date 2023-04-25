package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.gameobjects.BaseGameObject;

public class HealthDependentTexture extends RendererDecorator {
    public HealthDependentTexture(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public int getHealth(BaseGameObject baseGameObject) {
        return baseGameObject.getAbilities().getHealth();
    }

    @Override
    public void render(BaseGameObject baseGameObject, float delta) {
        float healthFraction = (float) getHealth(baseGameObject) / 100;

        Color color = new Color(game.batch.getColor());
        game.batch.setColor(1, healthFraction, healthFraction, 1);
        super.render(baseGameObject, delta);
        game.batch.setColor(color);
    }
}
