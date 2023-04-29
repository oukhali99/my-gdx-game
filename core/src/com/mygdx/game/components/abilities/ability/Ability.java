package com.mygdx.game.components.abilities.ability;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.transform.Transform;

public interface Ability {
    public void draw(float stateTime, Transform transform);

    public Vector2 getScale();

    public String getName();

    public void display();

    public int getDamage();

    public Animation getAnimation();
}
