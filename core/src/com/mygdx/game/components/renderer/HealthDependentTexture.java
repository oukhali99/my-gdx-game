package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

public class HealthDependentTexture extends RendererDecorator {
    public HealthDependentTexture(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public int getHealth(GameObject baseGameObject) {
        return baseGameObject.getAbilities().getHealth();
    }

    @Override
    public void render(GameObject baseGameObject, float delta) {
        float healthFraction = (float) getHealth(baseGameObject) / 100;

        Color color = new Color(game.batch.getColor());
        game.batch.setColor(1, healthFraction, healthFraction, 1);
        super.render(baseGameObject, delta);
        game.batch.setColor(color);
    }
}
