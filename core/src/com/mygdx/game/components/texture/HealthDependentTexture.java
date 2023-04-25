package com.mygdx.game.components.texture;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;

public abstract class HealthDependentTexture extends MyTexture {
    private MyTexture baseMyTexture;

    public HealthDependentTexture(Drop game, MyTexture baseMyTexture) {
        super(game, baseMyTexture.getTexturePath());
        this.baseMyTexture = baseMyTexture;
    }

    public HealthDependentTexture(HealthDependentTexture healthDependentTexture) {
        super(healthDependentTexture.baseMyTexture);
        baseMyTexture = new MyTexture(healthDependentTexture.baseMyTexture);
    }

    public abstract int getHealth();

    @Override
    protected void draw(float delta) {
        float healthFraction = (float) getHealth() / 100;

        Color color = new Color(game.batch.getColor());
        game.batch.setColor(1, healthFraction, healthFraction, 1);
        super.draw(delta);
        game.batch.setColor(color);
    }
}
