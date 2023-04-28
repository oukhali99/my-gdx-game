package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class NoUpdate extends Updater {
    public NoUpdate(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void onCollision(GameObject otherGameObject) {

    }
}
