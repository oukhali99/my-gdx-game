package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public abstract class BaseAbilities extends BaseComponent {
    public BaseAbilities(Drop game) {
        super(game);
    }

    public abstract void addAbility(Ability ability);

    public abstract List<Ability> getAbilityList();

    public abstract Ability getRandomAbility();

    public boolean hasAbilities() {
        return getAbilityList().size() > 0;
    }

    public abstract void takeDamage(int damage);

    public abstract void performAttack(GameObject thisBaseGameObject, Attack attack);

    public abstract Integer getHealth();
}
