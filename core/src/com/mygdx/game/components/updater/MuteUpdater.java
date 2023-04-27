package com.mygdx.game.components.updater;

import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class MuteUpdater extends BaseUpdaterDecorator {
    public MuteUpdater(Updater baseUpdater) {
        super(baseUpdater);
    }

    @Override
    public void update(Character character, float delta) {
        //super.update(gameObject, delta);
    }
}
