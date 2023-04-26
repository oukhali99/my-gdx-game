package com.mygdx.game.components;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;

public class Transform extends BaseComponent implements Component {
    private Vector2 position;
    private Vector2 scale;
    private float rotation;

    public Transform(Drop game) {
        super(game);
        this.position = new Vector2();
        this.scale = new Vector2(1, 1);
        this.rotation = 0;
    }

    public Transform(Drop game, Vector2 position, Vector2 scale, float rotation) {
        super(game);
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }

    public Transform(Transform transform) {
        super(transform.game);
        this.position = new Vector2(transform.position);
        this.scale = new Vector2(transform.scale);
        this.rotation = transform.rotation;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getScale() {
        return new Vector2(scale);
    }

    public void setScale(Vector2 scale) {
        this.scale = scale;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void translate(float x, float y) {
        this.position.add(x, y);
    }

    public void translate(Vector2 translation) {
        this.position.add(translation);
    }

    public void scale(float scaleX, float scaleY) {
        this.scale.scl(scaleX, scaleY);
    }

    public void scale(Vector2 scale) {
        this.scale.scl(scale);
    }

    public void rotate(float angle) {
        this.rotation += angle;
    }

    public void setRotationFromVector(Vector2 vector) {
        // Get the angle in degrees between the vector and the positive x-axis
        float angleDegrees = vector.angle();

        // Set the rotation of this transform to the angle
        setRotation(angleDegrees);
    }

    public Vector2 getCenter() {
        // Calculate the center point
        float centerX = position.x + (scale.x / 2.0f);
        float centerY = position.y + (scale.y / 2.0f);

        // Return a new vector representing the center point
        return new Vector2(centerX, centerY);
    }

    @Override
    public void destroy() {

    }
}
