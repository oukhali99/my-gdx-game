package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.components.updater.WASDMovement;
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

    @Override
    public Updater getUpdater() {
        return baseCharacter.getUpdater();
    }

    @Override
    public WASDMovement.MoveCommand getCurrentMoveCommand() {
        return baseCharacter.getCurrentMoveCommand();
    }

    @Override
    public void setCurrentMoveCommand(WASDMovement.MoveCommand moveCommand) {
        baseCharacter.setCurrentMoveCommand(moveCommand);
    }
}
