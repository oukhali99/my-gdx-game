package com.mygdx.game.gameobjects.combat.combatactors;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Abilities;
import com.mygdx.game.components.texture.HealthDependentTexture;
import com.mygdx.game.components.texture.Texture;
import com.mygdx.game.gameobjects.GameObject;

public abstract class CombatActor extends GameObject {
    private int health;

    protected CombatActor(Drop game) {
        super(game);
        this.health = 100;

        Abilities abilities = new Abilities(game);
        abilities.addAbility(new Abilities.Ability("Fireball", 10));
        abilities.addAbility(new Abilities.Ability("IceBlast", 8));
        addComponent(abilities);

        HealthDependentTexture healthDependentTexture = new HealthDependentTexture(game, new Texture(game, getTexturePath())) {
            @Override
            public int getHealth() {
                return health;
            }
        };
        addComponent(healthDependentTexture);
    }

    public Abilities getAbilitiesComponent() {
        return (Abilities) getComponent(Abilities.class);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    protected abstract String getTexturePath();
}
