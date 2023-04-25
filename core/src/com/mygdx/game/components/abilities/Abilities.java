package com.mygdx.game.components.abilities;

import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.gameplay.Ability;

import java.util.LinkedList;
import java.util.List;

public class Abilities extends BaseAbilities {
    private final List<Ability> abilityList;

    public Abilities(Drop game) {
        super(game);
        this.abilityList = new LinkedList<>();
    }

    @Override
    public void addAbility(Ability ability) {
        abilityList.add(ability);
    }

    @Override
    public List<Ability> getAbilityList() {
        return abilityList;
    }

    @Override
    public Ability getRandomAbility() {
        int size = abilityList.size();
        if (size == 0) {
            return null;
        }
        int randomIndex = MathUtils.random(0, size - 1);
        return abilityList.get(randomIndex);
    }

    @Override
    public void destroy() {

    }
}
