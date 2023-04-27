package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.gameobjects.GameObject;

public interface Character extends GameObject {
    public String getTexturePath();

    public Abilities getAbilities();

    public Integer getHealth();

    public void takeDamage(int damage);

    public Updater getUpdater();

    public WASDMovement.MoveCommand getCurrentMoveCommand();

    public void setCurrentMoveCommand(WASDMovement.MoveCommand moveCommand);
}
