package com.mygdx.game.gameobjects.combat.characters;

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
}
