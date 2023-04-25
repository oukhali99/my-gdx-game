package com.mygdx.game.gameobjects.combat.combatactors;

import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.renderer.HealthDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public abstract class CombatActor extends GameObject {
    private int health;

    protected CombatActor(Drop game) {
        super(game);
        this.health = 100;

        abilities = new Abilities(game);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));

        renderer = new MyTexture(game, getTexturePath());
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
