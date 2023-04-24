package com.mygdx.game.gameobjects.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModePlayer extends CombatModeGameObject {
    public CombatModePlayer(Drop game, GameObject gameObject) {
        super(game, gameObject);

        setPosition(200, 200);
    }
}
