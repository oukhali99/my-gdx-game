package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public interface Component {
    public Drop getGame();
    public GameObject getGameObject();
    public void destroy();
    public void setGameObject(GameObject gameObject);
}
