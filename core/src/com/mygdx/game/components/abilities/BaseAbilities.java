package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
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
}
