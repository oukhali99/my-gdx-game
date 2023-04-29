package com.mygdx.game.components.transform;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Component;

public interface Transform extends Component {
    Vector2 getPosition();

    void setPosition(Vector2 position);

    Vector2 getScale();

    void setScale(Vector2 scale);

    float getRotation();

    void setRotation(float rotation);

    void translate(float x, float y);

    void translate(Vector2 translation);

    void scale(float scaleX, float scaleY);

    void scale(Vector2 scale);

    void rotate(float angle);

    void setRotationFromVector(Vector2 vector);

    Vector2 getCenter();
}
