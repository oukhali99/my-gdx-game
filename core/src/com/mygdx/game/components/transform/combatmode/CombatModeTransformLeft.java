package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;

public class CombatModeTransformLeft extends CombatModeTransform {
    public CombatModeTransformLeft(Transform transform) {
        super(transform);
    }

    @Override
    protected Vector2 getCombatPosition() {
        return new Vector2(200, 200);
    }
}
