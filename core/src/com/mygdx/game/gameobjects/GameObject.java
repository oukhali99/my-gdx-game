package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.abilities.NoAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.collider.NoCollisions;
import com.mygdx.game.components.renderer.NoTexture;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.BaseUpdater;
import com.mygdx.game.components.updater.NoUpdate;

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
    protected BaseAbilities abilities;

    protected GameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game);
        this.markedForDestruction = false;
        this.children = new LinkedList<>();

        this.renderer = new NoTexture(game);
        this.baseUpdater = new NoUpdate(game);
        this.baseCollider = new NoCollisions(game);
        this.abilities = new NoAbilities(game);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
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
        return new LinkedList<>(children);
    }

    public void addChild(GameObject child) {
        children.add(child);
    }

    public void setCollider(BaseCollider collider) {
        this.baseCollider = collider;
    }

    public BaseAbilities getAbilities() {
        return abilities;
    }

    public Drop getGame() {
        return game;
    }

    public BaseUpdater getUpdater() {
        return baseUpdater;
    }
}
