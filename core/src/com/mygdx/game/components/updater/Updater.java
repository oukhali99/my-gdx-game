package com.mygdx.game.components.updater;

import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public interface Updater extends Component {
    void update(float delta);

    void onCollision(GameObject otherGameObject);
}
