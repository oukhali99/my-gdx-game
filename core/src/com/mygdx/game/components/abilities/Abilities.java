package com.mygdx.game.components.abilities;

import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public interface Abilities extends Component {

    public void addAbility(Ability ability);

    public abstract List<Ability> getAbilityList();

    public abstract Ability getRandomAbility();

    public boolean hasAbilities();

    public void takeDamage(GameObject currentGameObject, int damage);

    public void performAttack(GameObject thisGameObject, Attack attack);

    public Integer getHealth();
}
