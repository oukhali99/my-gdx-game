package com.mygdx.game.components.abilities;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseAbilities extends BaseComponent implements Abilities {
    public BaseAbilities(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    public boolean hasAbilities() {
        return getAbilityList().size() > 0;
    }
}
