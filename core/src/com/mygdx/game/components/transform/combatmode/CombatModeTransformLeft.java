package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.utils.mytiledmap.mapcell.MapCell;

public class CombatModeTransformLeft extends CombatModeTransform {
    public CombatModeTransformLeft(Transform transform, MapCell mapCell) {
        super(transform, mapCell);
    }

    @Override
    protected Vector2 getCombatPosition() {
        return new Vector2(220, 0);
    }
}
