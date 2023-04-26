package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public interface Component {
    public void destroy();

    public Drop getGame();

    public boolean equals(Object obj);
}
