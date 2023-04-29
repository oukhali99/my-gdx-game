package com.mygdx.game.components.abilities;

import com.mygdx.game.components.Component;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.gameobjects.attacks.Attack;

import java.util.List;

public interface Abilities extends Component {
    void addAbility(Ability ability);

    List<Ability> getAbilityList();

    Ability getRandomAbility();

    void performAttack(Attack attack);

    int getHealth();

    boolean hasAbilities();

    void takeDamage(int amount);

    void heal(int amount);
}
