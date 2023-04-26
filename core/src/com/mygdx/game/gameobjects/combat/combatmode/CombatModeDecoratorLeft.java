package com.mygdx.game.gameobjects.combat.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModeDecoratorLeft extends CombatModeDecorator {
    public CombatModeDecoratorLeft(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    protected Vector2 getInitialPosition() {
        return new Vector2(100, 200);
    }
}
