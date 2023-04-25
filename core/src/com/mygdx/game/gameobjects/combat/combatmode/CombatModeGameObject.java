package com.mygdx.game.gameobjects.combat.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.Attack;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;

public abstract class CombatModeGameObject extends GameObject {
    private CombatActor combatActor;

    public CombatModeGameObject(Drop game, CombatActor combatActor) {
        super(game);
        this.combatActor = combatActor;

        // Add the texture
        renderer = combatActor.getRenderer();

        // Scale up
        setScale(combatActor.getScale().cpy().scl(4));
    }

    public void performAttack(Attack attack) {
        children.add(attack);
        attack.getFight().endTurn();
    }

    public void takeDamage(int damage) {
        combatActor.takeDamage(damage);
    }

    public int getHealth() {
        return combatActor.getHealth();
    }

    public CombatActor getCombatActor() {
        return combatActor;
    }
}
