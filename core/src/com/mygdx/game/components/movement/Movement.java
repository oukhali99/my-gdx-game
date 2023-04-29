package com.mygdx.game.components.movement;

import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public interface Movement extends Component {
    void update(float delta);

    void onCollision(GameObject otherGameObject);

    void setSpeed(float speed);

    float getSpeed();

    void applySpeedBoost(float multiplier, float duration);
}
