package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobjects.BaseGameObjectDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModeDecorator extends BaseGameObjectDecorator {
    public CombatModeDecorator(GameObject baseGameObject) {
        super(baseGameObject);
    }

    @Override
    public Vector2 getPosition() {
        return super.getPosition();
    }

    @Override
    public Vector2 getScale() {
        return super.getScale().cpy().scl(4);
    }
}
