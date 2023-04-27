package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.gameobjects.GameObjectDecorator;

public class BaseCharacterDecorator extends GameObjectDecorator implements Character {
    private Character baseCharacter;
    public BaseCharacterDecorator(Character baseCharacter) {
        super(baseCharacter);
        this.baseCharacter = baseCharacter;
    }

    @Override
    public String getTexturePath() {
        return baseCharacter.getTexturePath();
    }

    @Override
    public Abilities getAbilities() {
        return baseCharacter.getAbilities();
    }

    @Override
    public Integer getHealth() {
        return baseCharacter.getHealth();
    }

    @Override
    public void takeDamage(int damage) {
        baseCharacter.takeDamage(damage);
    }
}
