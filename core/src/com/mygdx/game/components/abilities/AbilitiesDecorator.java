package com.mygdx.game.components.abilities;

import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public class AbilitiesDecorator extends BaseAbilities {
    private BaseAbilities baseAbilities;

    public AbilitiesDecorator(BaseAbilities baseAbilities) {
        super(baseAbilities.getGame());
        this.baseAbilities = baseAbilities;
    }

    @Override
    public void destroy() {
        baseAbilities.destroy();
    }

    @Override
    public void addAbility(Ability ability) {
        baseAbilities.addAbility(ability);
    }

    @Override
    public List<Ability> getAbilityList() {
        return baseAbilities.getAbilityList();
    }

    @Override
    public Ability getRandomAbility() {
        return baseAbilities.getRandomAbility();
    }

    @Override
    public void takeDamage(GameObject currentGameObject, int damage) {
        baseAbilities.takeDamage(currentGameObject, damage);
    }

    @Override
    public void performAttack(GameObject thisGameObject, Attack attack) {
        baseAbilities.performAttack(thisGameObject, attack);
    }

    @Override
    public Integer getHealth() {
        return baseAbilities.getHealth();
    }
}