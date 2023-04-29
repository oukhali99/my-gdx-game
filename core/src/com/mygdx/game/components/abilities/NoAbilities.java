package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.components.abilities.ability.Ability;

import java.util.List;

public class NoAbilities extends Abilities {
    public NoAbilities(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void addAbility(Ability ability) {

    }

    @Override
    public List<Ability> getAbilityList() {
        return null;
    }

    @Override
    public Ability getRandomAbility() {
        return null;
    }

    @Override
    public void performAttack(Attack attack) {

    }
}
