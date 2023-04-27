package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class NoUpdate extends BaseUpdater {
    public NoUpdate(Drop game) {
        super(game);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void update(Character character, float delta) {

    }

    @Override
    public void onCollision(GameObject gameObject, GameObject otherGameObject) {

    }
}
