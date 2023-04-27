package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class HealthDependentTexture extends RendererDecorator {
    public HealthDependentTexture(Renderer baseRenderer) {
        super(baseRenderer);
    }

    public int getHealth(GameObject gameObject) {
        if (gameObject instanceof Character) {
            Character character = (Character) gameObject;
            return character.getAbilities().getHealth();
        }
        return 0;
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        float healthFraction = (float) getHealth(gameObject) / 100;

        Color color = new Color(getGame().batch.getColor());
        getGame().batch.setColor(new Color(1, healthFraction, healthFraction, 1).mul(color));
        super.render(gameObject, delta);
        getGame().batch.setColor(color);
    }
}
