package com.mygdx.game.gameobjects.combat.characters.combatmode;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class CombatModeDecoratorLeft extends CombatModeDecorator {
    public CombatModeDecoratorLeft(Character character) {
        super(character);
    }

    @Override
    protected Vector2 getInitialPosition() {
        return new Vector2(100, 200);
    }
}
