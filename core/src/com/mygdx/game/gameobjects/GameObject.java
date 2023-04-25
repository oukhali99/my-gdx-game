package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.collider.NoCollisions;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.renderer.NoTexture;
import com.mygdx.game.components.updater.NoUpdate;
import com.mygdx.game.components.updater.BaseUpdater;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    protected Transform transform;
    private boolean markedForDestruction;
    protected List<GameObject> children;
    protected Renderer renderer;
    protected BaseUpdater baseUpdater;
    protected BaseCollider baseCollider;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game);
        this.markedForDestruction = false;
        this.children = new LinkedList<>();

        this.renderer = new NoTexture(game);
        this.baseUpdater = new NoUpdate(game);
        this.baseCollider = new NoCollisions(game);

        initialize();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    protected void initialize() {
    }

    public void render(float delta) {
        renderer.render(this, delta);

        for (GameObject child : children) {
            child.render(delta);
        }
    }

    public void update(float delta) {
        baseUpdater.update(this, delta);

        for (GameObject child : children) {
            child.update(delta);
        }
    }

    public void postUpdate(float delta) {
        baseCollider.postUpdate(delta, game.getScreen().getGameObjects(), this);

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
    }

    public BaseCollider getCollider() {
        return baseCollider;
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
        for (GameObject child : children) {
            child.destroy();
        }
    }

    public BaseComponent getComponent(Class<? extends BaseComponent> componentClass) {
        return null;
    }

    public void postPostUpdate(float delta) {
        baseCollider.postPostUpdate(delta);

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

    public void setCollider(BaseCollider collider) {
        this.baseCollider = collider;
    }
}
