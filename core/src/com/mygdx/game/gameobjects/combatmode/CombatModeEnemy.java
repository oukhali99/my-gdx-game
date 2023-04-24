package com.mygdx.game.gameobjects.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModeEnemy extends CombatModeGameObject {
    public CombatModeEnemy(Drop game, GameObject gameObject) {
        super(game, gameObject);

        setPosition(800, 200);
    }
}
