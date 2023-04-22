package com.mygdx.game.components;

import com.badlogic.gdx.math.Vector2;

public class Transform {
    private Vector2 position;
    private Vector2 scale;
    private float rotation;

    public Transform() {
        this.position = new Vector2();
        this.scale = new Vector2(1, 1);
        this.rotation = 0;
    }

    public Transform(Vector2 position, Vector2 scale, float rotation) {
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getScale() {
        return scale;
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
}
