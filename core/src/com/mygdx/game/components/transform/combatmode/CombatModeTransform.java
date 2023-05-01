package com.mygdx.game.components.transform.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.components.transform.TransformBaseDecorator;
import com.mygdx.game.utils.mytiledmap.mapcell.MapCell;

public abstract class CombatModeTransform extends TransformBaseDecorator {
    private MapCell enemyMapCell;

    public CombatModeTransform(Transform transform, MapCell enemyMapCell) {
        super(transform);
        //setPosition(getCombatPosition());
        this.enemyMapCell = enemyMapCell;
    }

    @Override
    public Vector2 getPosition() {
        Vector2 combatBasePosition = enemyMapCell.getCombatBasePosition().cpy();
        return combatBasePosition.add(getCombatPosition());
    }

    @Override
    public Vector2 getScale() {
        return new Vector2(64, 64);
    }

    protected abstract Vector2 getCombatPosition();
}
