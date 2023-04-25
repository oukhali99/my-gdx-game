package com.mygdx.game.gameobjects.combat.combatactors;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Abilities;
import com.mygdx.game.components.texture.HealthDependentTexture;
import com.mygdx.game.components.texture.MyTexture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public abstract class CombatActor extends GameObject {
    private int health;

    protected CombatActor(Drop game) {
        super(game);
        this.health = 100;

        Abilities abilities = new Abilities(game);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));
        addComponent(abilities);

        HealthDependentTexture healthDependentTexture = new HealthDependentTexture(game, new MyTexture(game, getTexturePath())) {
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

        if (health <= 0) {
            health = 0;
            markForDestruction();
        }
    }

    protected abstract String getTexturePath();

    public int getHealth() {
        return health;
    }
}
