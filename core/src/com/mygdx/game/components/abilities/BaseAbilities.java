package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;

public abstract class BaseAbilities extends BaseComponent implements Abilities {
    public BaseAbilities(Drop game) {
        super(game);
    }

    public boolean hasAbilities() {
        return getAbilityList().size() > 0;
    }
}
