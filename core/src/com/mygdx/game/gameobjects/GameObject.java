package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Transform;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    private List<Component> components;
    protected Transform transform;
    protected Texture texture;
    private boolean markedForDestruction;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform();
        this.components = new LinkedList<>();
        this.markedForDestruction = false;

        initialize();
    }

    protected void initialize() {
        texture = new Texture(Gdx.files.internal(getTexturePath()));
    }

    public void render(float delta) {
        game.batch.draw(
            texture,
            transform.getPosition().x,
            transform.getPosition().y,
            transform.getScale().x,
            transform.getScale().y
        );
    }

    public void update(float delta) {
        for (Component component : components) {
            component.update(delta);
        }
    }

    public void postUpdate(float delta) {
        for (Component component : components) {
            component.postUpdate(delta);
        }
    }

    protected abstract String getTexturePath();

    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }

    public void addComponent(Component component) {
        components.add(component);
        component.attachToGameObject(this);
    }

    public Transform getTransform() {
        return transform;
    }

    public boolean isMarkedForDestruction() {
        return markedForDestruction;
    }

    public void markForDestruction() {
        markedForDestruction = true;
    }

    public void destroy() {
        for (Component component : components) {
            component.destroy();
        }

        texture.dispose();
    }
}
