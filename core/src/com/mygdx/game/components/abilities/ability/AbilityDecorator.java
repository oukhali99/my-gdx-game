package com.mygdx.game.components.abilities.ability;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;

public class AbilityDecorator implements Ability {
    private final Ability baseAbility;

    public AbilityDecorator(Ability baseAbility) {
        this.baseAbility = baseAbility;
    }

    @Override
    public Vector2 getScale() {
        return baseAbility.getScale();
    }

    @Override
    public String getName() {
        return baseAbility.getName();
    }

    @Override
    public void display() {
        baseAbility.display();
    }

    @Override
    public int getDamage() {
        return baseAbility.getDamage();
    }

    @Override
    public Animation getAnimation() {
        return baseAbility.getAnimation();
    }

    @Override
    public void draw(float stateTime, Transform transform) {
        baseAbility.draw(stateTime, transform);
    }
}
