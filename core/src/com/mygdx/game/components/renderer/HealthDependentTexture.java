package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public abstract class HealthDependentTexture extends Renderer {
    private Renderer baseMyTexture;

    public HealthDependentTexture(Drop game, MyTexture baseMyTexture) {
        super(game);
        this.baseMyTexture = baseMyTexture;
    }

    public HealthDependentTexture(HealthDependentTexture healthDependentTexture) {
        super(healthDependentTexture.baseMyTexture);
    }

    public abstract int getHealth();

    @Override
    public void render(GameObject gameObject, float delta) {
        float healthFraction = (float) getHealth() / 100;

        Color color = new Color(game.batch.getColor());
        game.batch.setColor(1, healthFraction, healthFraction, 1);
        baseMyTexture.render(gameObject, delta);
        game.batch.setColor(color);
    }

    @Override
    public void destroy() {
        baseMyTexture.destroy();
    }
}
