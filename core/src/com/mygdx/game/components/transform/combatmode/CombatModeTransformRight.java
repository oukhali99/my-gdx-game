package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.utils.mytiledmap.mapcell.MapCell;

public class CombatModeTransformRight extends CombatModeTransform {
    public CombatModeTransformRight(Transform transform, MapCell enemyTile) {
        super(transform, enemyTile);
    }

    @Override
    public Vector2 getCombatPosition() {
        return new Vector2(1700, 0);
    }
}
