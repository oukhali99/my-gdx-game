package com.mygdx.game.components;

import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public interface Component {

    public void render(float delta);

    public void update(float delta);

    public void postUpdate(float delta);

    public void attachToGameObject(GameObject gameObject);

    public void destroy();

    public void postPostUpdate(float delta);
}
