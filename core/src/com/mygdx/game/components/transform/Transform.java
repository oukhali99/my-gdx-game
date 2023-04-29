package com.mygdx.game.components.transform;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.Component;

public interface Transform extends Component {
    public Vector2 getPosition();

    public void setPosition(Vector2 position);

    public Vector2 getScale();

    public void setScale(Vector2 scale);

    public float getRotation();

    public void setRotation(float rotation);

    public void translate(float x, float y);

    public void translate(Vector2 translation);

    public void scale(float scaleX, float scaleY);

    public void scale(Vector2 scale);

    public void rotate(float angle);

    public void setRotationFromVector(Vector2 vector);

    public Vector2 getCenter();
}
