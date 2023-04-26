package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

public abstract class BaseUpdater extends BaseComponent implements Updater {
    public BaseUpdater(Drop game) {
        super(game);
    }
}
