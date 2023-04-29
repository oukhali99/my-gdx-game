package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public interface Component {
    Drop getGame();

    GameObject getGameObject();

    void setGameObject(GameObject gameObject);

    void destroy();
}
