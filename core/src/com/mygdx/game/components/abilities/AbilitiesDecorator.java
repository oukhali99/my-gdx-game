package com.mygdx.game.components.abilities;

import com.mygdx.game.components.BaseComponentDecorator;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.gameobjects.combat.characters.Character;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public class AbilitiesDecorator extends BaseComponentDecorator implements Abilities {
    private Abilities baseAbilities;

    public AbilitiesDecorator(Abilities baseAbilities) {
        super(baseAbilities);
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
    public boolean hasAbilities() {
        return baseAbilities.hasAbilities();
    }

    @Override
    public void performAttack(Character thisGameObject, Attack attack) {
        baseAbilities.performAttack(thisGameObject, attack);
    }
}
