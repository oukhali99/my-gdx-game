package com.mygdx.game.gameobjects.combat.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;

public class CombatModePlayer extends CombatModeGameObject {
    public CombatModePlayer(Drop game, CombatActor gameObject) {
        super(game, gameObject);

        setPosition(200, 200);
    }
}
