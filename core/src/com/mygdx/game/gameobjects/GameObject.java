package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Transform;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    protected List<BaseComponent> baseComponents;
    protected Transform transform;
    private boolean markedForDestruction;
    protected List<GameObject> children;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game);
        this.baseComponents = new LinkedList<>();
        this.markedForDestruction = false;
        this.children = new LinkedList<>();

        initialize();
    }

    protected void initialize() {
    }

    public void render(float delta) {
        for (BaseComponent baseComponent : baseComponents) {
            baseComponent.render(delta);
        }
        for (GameObject child : children) {
            child.render(delta);
        }
    }

    public void update(float delta) {
        for (BaseComponent baseComponent : baseComponents) {
            baseComponent.update(delta);
        }
        for (GameObject child : children) {
            child.update(delta);
        }
    }

    public void postUpdate(float delta) {
        for (BaseComponent baseComponent : baseComponents) {
            baseComponent.postUpdate(delta);
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

    public void addComponent(BaseComponent baseComponent) {
        baseComponents.add(baseComponent);
        baseComponent.attachToGameObject(this);
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
        for (BaseComponent baseComponent : baseComponents) {
            baseComponent.destroy();
        }
        for (GameObject child : children) {
            child.destroy();
        }
    }

    public BaseComponent getComponent(Class<? extends BaseComponent> componentClass) {
        for (BaseComponent baseComponent : baseComponents) {
            if (componentClass.isInstance(baseComponent)) {
                return baseComponent;
            }
        }
        return null;
    }

    public void postPostUpdate(float delta) {
        for (BaseComponent baseComponent : baseComponents) {
            baseComponent.postPostUpdate(delta);
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

    public List<GameObject> getChildren() {
        return children;
    }
}
