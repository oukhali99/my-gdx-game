package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.TransformBaseDecorator;
import com.mygdx.game.components.transform.Transform;

public abstract class CombatModeTransform extends TransformBaseDecorator {
    public CombatModeTransform(Transform transform) {
        super(transform);
        //setPosition(getCombatPosition());
    }

    @Override
    public Vector2 getPosition() {
        return getCombatPosition();
    }

    protected abstract Vector2 getCombatPosition();
}
