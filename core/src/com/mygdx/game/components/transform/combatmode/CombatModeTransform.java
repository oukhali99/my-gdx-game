package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.components.transform.TransformBaseDecorator;

public abstract class CombatModeTransform extends TransformBaseDecorator {
    public CombatModeTransform(Transform transform) {
        super(transform);
        //setPosition(getCombatPosition());
    }

    @Override
    public Vector2 getPosition() {
        return getCombatPosition();
    }

    @Override
    public Vector2 getScale() {
        return new Vector2(64, 64);
    }

    protected abstract Vector2 getCombatPosition();
}
