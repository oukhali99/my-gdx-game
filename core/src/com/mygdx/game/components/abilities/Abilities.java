package com.mygdx.game.components.abilities;

import com.mygdx.game.components.Component;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.gameobjects.combat.attacks.Attack;

import java.util.List;

public interface Abilities extends Component {
    public void addAbility(Ability ability);

    public List<Ability> getAbilityList();

    public Ability getRandomAbility();

    public void performAttack(Attack attack);

    public int getHealth();

    public boolean hasAbilities();

    public void takeDamage(int amount);
}
