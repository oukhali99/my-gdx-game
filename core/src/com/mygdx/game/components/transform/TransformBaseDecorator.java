package com.mygdx.game.components.transform;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.ComponentBaseDecorator;

public class TransformBaseDecorator extends ComponentBaseDecorator implements Transform {
    private Transform baseTransform;

    public TransformBaseDecorator(Transform baseTransform) {
        super(baseTransform);
        this.baseTransform = baseTransform;
    }

    @Override
    public Vector2 getPosition() {
        return baseTransform.getPosition();
    }

    @Override
    public void setPosition(Vector2 position) {
        baseTransform.setPosition(position);
    }

    @Override
    public Vector2 getScale() {
        return baseTransform.getScale();
    }

    @Override
    public void setScale(Vector2 scale) {
        baseTransform.setScale(scale);
    }

    @Override
    public float getRotation() {
        return baseTransform.getRotation();
    }

    @Override
    public void setRotation(float rotation) {
        baseTransform.setRotation(rotation);
    }

    @Override
    public void translate(float x, float y) {
        baseTransform.translate(x, y);
    }

    @Override
    public void translate(Vector2 translation) {
        baseTransform.translate(translation);
    }

    @Override
    public void scale(float scaleX, float scaleY) {
        baseTransform.scale(scaleX, scaleY);
    }

    @Override
    public void scale(Vector2 scale) {
        baseTransform.scale(scale);
    }

    @Override
    public void rotate(float angle) {
        baseTransform.rotate(angle);
    }

    @Override
    public void setRotationFromVector(Vector2 vector) {
        baseTransform.setRotationFromVector(vector);
    }

    @Override
    public Vector2 getCenter() {
        return baseTransform.getCenter();
    }
}
