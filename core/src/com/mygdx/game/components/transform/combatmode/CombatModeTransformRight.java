package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;

public class CombatModeTransformRight extends CombatModeTransform {
    public CombatModeTransformRight(Transform transform) {
        super(transform);
    }

    @Override
    public Vector2 getCombatPosition() {
        return new Vector2(400, 200);
    }
}
