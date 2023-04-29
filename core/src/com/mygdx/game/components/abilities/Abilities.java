package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public abstract class Abilities extends Component {
    private int health;

    public Abilities(Drop game, GameObject gameObject) {
        super(game, gameObject);
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public boolean hasAbilities() {
        return getAbilityList().size() > 0;
    }

    public abstract void addAbility(Ability ability);

    public abstract List<Ability> getAbilityList();

    public abstract Ability getRandomAbility();

    public abstract void performAttack(Attack attack);

    public void takeDamage(int amount) {
        health -= amount;

        if (health <= 0) {
            health = 0;
            gameObject.markForDestruction();
        }
    }
}
