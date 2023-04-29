package com.mygdx.game.components.abilities;

import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.components.abilities.ability.Ability;

import java.util.List;

public class AbilitiesDecorator extends Abilities {
    private Abilities baseAbilities;

    public AbilitiesDecorator(Abilities baseAbilities) {
        super(baseAbilities.getGame(), baseAbilities.getGameObject());
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
    public int getHealth() {
        return baseAbilities.getHealth();
    }

    @Override
    public boolean hasAbilities() {
        return baseAbilities.hasAbilities();
    }

    @Override
    public void performAttack(Attack attack) {
        baseAbilities.performAttack(attack);
    }
}
