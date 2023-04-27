package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.gameobjects.GameObject;

public interface Character extends GameObject {
    public String getTexturePath();

    public Abilities getAbilities();
}