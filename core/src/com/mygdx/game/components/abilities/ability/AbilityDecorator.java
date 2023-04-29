package com.mygdx.game.components.abilities.ability;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.utils.SpriteSheet;

public class AbilityDecorator extends Ability {
    private Ability ability;

    public AbilityDecorator(Ability ability) {
        super(ability.getGame(), ability.getName(), ability.getDamage());
        this.ability = ability;
    }

    @Override
    protected SpriteSheet getSpriteSheet() {
        return ability.getSpriteSheet();
    }

    @Override
    public Vector2 getScale() {
        return ability.getScale();
    }

    @Override
    public String getName() {
        return ability.getName();
    }

    @Override
    public void display() {
        ability.display();
    }

    @Override
    public int getDamage() {
        return ability.getDamage();
    }

    @Override
    public Animation getAnimation() {
        return ability.getAnimation();
    }

    @Override
    public void draw(float stateTime, Transform transform) {
        ability.draw(stateTime, transform);
    }
}
