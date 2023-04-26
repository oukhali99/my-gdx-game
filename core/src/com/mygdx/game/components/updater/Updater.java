package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public interface Updater extends Component  {
    public void update(GameObject gameObject, float delta);

    public void onCollision(GameObject gameObject, GameObject otherGameObject);
}
