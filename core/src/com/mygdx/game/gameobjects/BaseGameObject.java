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

public abstract class BaseGameObject implements GameObject {
    protected final Drop game;
    protected Transform transform;
    private boolean markedForDestruction;
    protected List<BaseGameObject> children;
    protected Renderer renderer;
    protected BaseUpdater baseUpdater;
    protected BaseCollider baseCollider;
    protected BaseAbilities abilities;

    protected BaseGameObject(final Drop game) {
        this.game = game;
        this.transform = new Transform(game);
        this.markedForDestruction = false;
        this.children = new LinkedList<>();

        this.renderer = new NoTexture(game);
        this.baseUpdater = new NoUpdate(game);
        this.baseCollider = new NoCollisions(game);
        this.abilities = new NoAbilities(game);
    }

    @Override
    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void render(float delta) {
        getRenderer().render(getThis(), delta);

        for (BaseGameObject child : children) {
            child.render(delta);
        }
    }

    @Override
    public void update(float delta) {
        getUpdater().update(getThis(), delta);

        for (BaseGameObject child : children) {
            child.update(delta);
        }
    }

    @Override
    public void postUpdate(float delta) {
        getCollider().postUpdate(delta, game.getScreen().getGameObjects(), getThis());

        for (BaseGameObject child : children) {
            child.postUpdate(delta);
        }
    }

    @Override
    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    @Override
    public void setPosition(Vector2 position) {
        transform.setPosition(new Vector2(position));
    }

    @Override
    public Vector2 getPosition() {
        return transform.getPosition();
    }

    @Override
    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }

    @Override
    public void setScale(Vector2 scale) {
        transform.setScale(new Vector2(scale));
    }

    @Override
    public Vector2 getScale() {
        return transform.getScale();
    }

    @Override
    public BaseCollider getCollider() {
        return baseCollider;
    }

    @Override
    public Transform getTransform() {
        return transform;
    }

    @Override
    public boolean isMarkedForDestruction() {
        return markedForDestruction;
    }

    @Override
    public void markForDestruction() {
        markedForDestruction = true;
    }

    @Override
    public void destroy() {
        for (BaseGameObject child : children) {
            child.destroy();
        }
    }

    @Override
    public void postPostUpdate(float delta) {
        getCollider().postPostUpdate(delta);

        for (BaseGameObject child : children) {
            child.postPostUpdate(delta);
        }
    }

    @Override
    public void preenDestroyedChildren() {
        List<BaseGameObject> enabledBaseGameObjects = new LinkedList<>();
        for (BaseGameObject baseGameObject : children) {
            if (baseGameObject.isMarkedForDestruction()) {
                baseGameObject.destroy();
            }
            else {
                enabledBaseGameObjects.add(baseGameObject);
            }
        }
        children = enabledBaseGameObjects;
    }

    @Override
    public List<BaseGameObject> getChildren() {
        return new LinkedList<>(children);
    }

    public void addChild(BaseGameObject child) {
        children.add(child);
    }

    @Override
    public void setCollider(BaseCollider collider) {
        this.baseCollider = collider;
    }

    @Override
    public BaseAbilities getAbilities() {
        return abilities;
    }

    @Override
    public Drop getGame() {
        return game;
    }

    @Override
    public boolean equals(GameObject obj) {
        if (this == obj) {
            return true;
        }

        return super.equals(obj);
    }

    @Override
    public BaseUpdater getUpdater() {
        return baseUpdater;
    }

    public GameObject getThis() {
        return this;
    }
}
