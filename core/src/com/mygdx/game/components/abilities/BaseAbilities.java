package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.components.abilities.ability.Ability;

import java.util.List;

public abstract class BaseAbilities extends BaseComponent implements Abilities {
    private int health;

    public BaseAbilities(Drop game, GameObject gameObject) {
        super(game, gameObject);
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public boolean hasAbilities() {
        return getAbilityList().size() > 0;
    }

    public void takeDamage(int amount) {
        health -= amount;

        if (health <= 0) {
            health = 0;
            gameObject.markForDestruction();
        }
    }
}
