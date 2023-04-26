package com.mygdx.game.gameobjects.combat.attacks;

import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.screens.CombatScreen;

public interface Attack extends GameObject {
    public CombatScreen.Fight getFight();

    public Integer getDamage();
}
