package com.mygdx.game.components.abilities.ability;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;

public interface Ability {
    void draw(float stateTime, Transform transform);

    Vector2 getScale();

    String getName();

    void display();

    int getDamage();

    Animation getAnimation();
}
