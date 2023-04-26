package com.mygdx.game.gameobjects.combat.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Transform;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.GameObjectDecorator;

public abstract class CombatModeDecorator extends GameObjectDecorator implements GameObject {
    public CombatModeDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public Transform getTransform() {
        Transform modifiedTransform = super.getTransform();

        modifiedTransform.setScale(new Vector2(100, 100));
        modifiedTransform.setPosition(getInitialPosition());

        return modifiedTransform;
    }

    protected abstract Vector2 getInitialPosition();
}
