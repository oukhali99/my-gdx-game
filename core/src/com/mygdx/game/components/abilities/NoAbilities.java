package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.gameplay.Ability;

import java.util.List;

public class NoAbilities extends BaseAbilities {
    public NoAbilities(Drop game) {
        super(game);
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
}
