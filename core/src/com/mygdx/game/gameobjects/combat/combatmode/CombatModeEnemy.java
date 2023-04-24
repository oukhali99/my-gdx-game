package com.mygdx.game.gameobjects.combat.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;

public class CombatModeEnemy extends CombatModeGameObject {
    public CombatModeEnemy(Drop game, CombatActor gameObject) {
        super(game, gameObject);

        setPosition(800, 200);
    }
}
