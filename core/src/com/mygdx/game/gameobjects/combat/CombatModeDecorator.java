package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Transform;
import com.mygdx.game.gameobjects.BaseGameObjectDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModeDecorator extends BaseGameObjectDecorator {
    public CombatModeDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public Transform getTransform() {
        Transform modifiedTransform = new Transform(super.getTransform());

        modifiedTransform.setScale(new Vector2(200, 200));

        return modifiedTransform;
    }
}
