package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModeDecoratorRight extends CombatModeDecorator {
    public CombatModeDecoratorRight(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    protected Vector2 getInitialPosition() {
        return new Vector2(600, 200);
    }
}