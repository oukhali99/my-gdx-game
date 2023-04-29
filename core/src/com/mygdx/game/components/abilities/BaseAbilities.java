package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

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

    @Override
    public void heal(int amount) {
        health += amount;
    }
}
