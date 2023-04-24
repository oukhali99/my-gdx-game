package com.mygdx.game.gameobjects.combat.combatactors;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Abilities;
import com.mygdx.game.gameobjects.GameObject;

public abstract class CombatActor extends GameObject {
    protected CombatActor(Drop game) {
        super(game);

        Abilities abilities = new Abilities(game);
        abilities.addAbility(new Abilities.Ability("Fireball", 10));
        abilities.addAbility(new Abilities.Ability("IceBlast", 8));
        addComponent(abilities);
    }

    public Abilities getAbilitiesComponent() {
        return (Abilities) getComponent(Abilities.class);
    }
}
