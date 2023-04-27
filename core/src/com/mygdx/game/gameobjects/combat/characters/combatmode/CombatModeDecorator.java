package com.mygdx.game.gameobjects.combat.characters.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.updater.MuteUpdater;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.GameObjectDecorator;
import com.mygdx.game.gameobjects.combat.characters.BaseCharacterDecorator;
import com.mygdx.game.gameobjects.combat.characters.Character;

public abstract class CombatModeDecorator extends BaseCharacterDecorator implements Character {
    public CombatModeDecorator(Character character) {
        super(character);
    }

    @Override
    public Transform getTransform() {
        Transform modifiedTransform = super.getTransform();

        modifiedTransform.setScale(new Vector2(100, 100));
        modifiedTransform.setPosition(getInitialPosition());

        return modifiedTransform;
    }

    @Override
    public Updater getUpdater() {
        return new MuteUpdater(super.getUpdater());
    }

    protected abstract Vector2 getInitialPosition();
}
