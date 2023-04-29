package com.mygdx.game.components.updater;

import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public interface Updater extends Component {
    public void update(float delta);

    public void onCollision(GameObject otherGameObject);
}
