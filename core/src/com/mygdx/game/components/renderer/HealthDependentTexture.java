package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class HealthDependentTexture extends RendererDecorator {
    public HealthDependentTexture(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public int getHealth(GameObject gameObject) {
        return gameObject.getAbilities().getHealth();
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        float healthFraction = (float) getHealth(gameObject) / 100;

        Color color = new Color(game.batch.getColor());
        game.batch.setColor(new Color(1, healthFraction, healthFraction, 1).mul(color));
        super.render(gameObject, delta);
        game.batch.setColor(color);
    }
}
