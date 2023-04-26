package com.mygdx.game.components.abilities;

import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.Logger;

public class InvincibleDecorator extends AbilitiesDecorator {
    public InvincibleDecorator(BaseAbilities baseAbilities) {
        super(baseAbilities);
    }

    @Override
    public void takeDamage(GameObject currentGameObject, int damage) {
        Logger.log(currentGameObject + " IS INVINCIBLE!!! MUAHAHAHA");
    }
}
