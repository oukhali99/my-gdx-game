package com.mygdx.game.gameobjects.combat.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Abilities;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.texture.HealthDependentTexture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.Attack;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;

public abstract class CombatModeGameObject extends GameObject {
    private CombatActor combatActor;

    public CombatModeGameObject(Drop game, CombatActor combatActor) {
        super(game);
        this.combatActor = combatActor;

        // Add the texture
        final HealthDependentTexture healthDependentTexture = (HealthDependentTexture) combatActor.getComponent(HealthDependentTexture.class);
        addComponent(new HealthDependentTexture(healthDependentTexture) {
            @Override
            public int getHealth() {
                return healthDependentTexture.getHealth();
            }
        });

        // Copy the abilities
        Abilities baseAbilities = (Abilities) combatActor.getComponent(Abilities.class);
        addComponent(new Abilities(baseAbilities));

        // Scale up
        setScale(combatActor.getScale().cpy().scl(4));

        // Add collider
        addComponent(new Collider(game));
    }

    public void performAttack(Attack attack) {
        children.add(attack);
    }

    public void takeDamage(int damage) {
        combatActor.takeDamage(damage);
    }

    public int getHealth() {
        return combatActor.getHealth();
    }
}
