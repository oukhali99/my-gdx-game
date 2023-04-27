package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public abstract class IntegerDependentTexture extends RendererDecorator {
    public IntegerDependentTexture(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public abstract int getInteger(GameObject gameObject);

    @Override
    public void render(GameObject gameObject, float delta) {
        float healthFraction = (float) getInteger(gameObject) / 100;

        Color color = new Color(getGame().batch.getColor());
        getGame().batch.setColor(new Color(1, healthFraction, healthFraction, 1).mul(color));
        super.render(gameObject, delta);
        getGame().batch.setColor(color);
    }
}
