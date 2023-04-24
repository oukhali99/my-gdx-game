package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Transform;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    protected List<Component> components;
    protected Transform transform;
    private boolean markedForDestruction;
    protected List<GameObject> children;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game);
        this.components = new LinkedList<>();
        this.markedForDestruction = false;
        this.children = new LinkedList<>();

        initialize();
    }

    protected void initialize() {
    }

    public void render(float delta) {
        for (Component component : components) {
            component.render(delta);
        }
        for (GameObject child : children) {
            child.render(delta);
        }
    }

    public void update(float delta) {
        for (Component component : components) {
            component.update(delta);
        }
        for (GameObject child : children) {
            child.update(delta);
        }
    }

    public void postUpdate(float delta) {
        for (Component component : components) {
            component.postUpdate(delta);
        }
        for (GameObject child : children) {
            child.postUpdate(delta);
        }
    }

    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    public void setPosition(Vector2 position) {
        transform.setPosition(new Vector2(position));
    }

    public Vector2 getPosition() {
        return transform.getPosition();
    }

    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }

    public void setScale(Vector2 scale) {
        transform.setScale(new Vector2(scale));
    }

    public Vector2 getScale() {
        return transform.getScale();
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
        for (GameObject child : children) {
            child.destroy();
        }
    }

    public Component getComponent(Class<? extends Component> componentClass) {
        for (Component component : components) {
            if (componentClass.isInstance(component)) {
                return component;
            }
        }
        return null;
    }

    public void postPostUpdate(float delta) {
        for (Component component : components) {
            component.postPostUpdate(delta);
        }
        for (GameObject child : children) {
            child.postPostUpdate(delta);
        }
    }

    public void preenDestroyedChildren() {
        List<GameObject> enabledGameObjects = new LinkedList<>();
        for (GameObject gameObject : children) {
            if (gameObject.isMarkedForDestruction()) {
                gameObject.destroy();
            }
            else {
                enabledGameObjects.add(gameObject);
            }
        }
        children = enabledGameObjects;
    }
}
