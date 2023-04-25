package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.Renderer;

import java.util.List;

public class BaseGameObjectDecorator implements GameObject {
    private GameObject gameObject;

    public BaseGameObjectDecorator(GameObject baseGameObject) {
        this.gameObject = baseGameObject;
    }

    @Override
    public Renderer getRenderer() {
        return gameObject.getRenderer();
    }

    @Override
    public void setRenderer(Renderer renderer) {
        gameObject.setRenderer(renderer);
    }

    @Override
    public void render(float delta) {
        gameObject.render(delta);
    }

    @Override
    public void update(float delta) {
        gameObject.update(delta);
    }

    @Override
    public void postUpdate(float delta) {
        gameObject.postUpdate(delta);
    }

    @Override
    public void setPosition(float x, float y) {
        gameObject.setPosition(x, y);
    }

    @Override
    public void setPosition(Vector2 position) {
        gameObject.setPosition(position);
    }

    @Override
    public Vector2 getPosition() {
        return gameObject.getPosition();
    }

    @Override
    public void setScale(float x, float y) {
        gameObject.setScale(x, y);
    }

    @Override
    public void setScale(Vector2 scale) {
        gameObject.setScale(scale);
    }

    @Override
    public Vector2 getScale() {
        return gameObject.getScale();
    }

    @Override
    public BaseCollider getCollider() {
        return gameObject.getCollider();
    }

    @Override
    public Transform getTransform() {
        return gameObject.getTransform();
    }

    @Override
    public boolean isMarkedForDestruction() {
        return gameObject.isMarkedForDestruction();
    }

    @Override
    public void markForDestruction() {
        gameObject.markForDestruction();
    }

    @Override
    public void destroy() {
        gameObject.destroy();
    }

    @Override
    public void postPostUpdate(float delta) {
        gameObject.postPostUpdate(delta);
    }

    @Override
    public void preenDestroyedChildren() {
        gameObject.preenDestroyedChildren();
    }

    @Override
    public List<BaseGameObject> getChildren() {
        return gameObject.getChildren();
    }

    @Override
    public void addChild(BaseGameObject child) {
        gameObject.addChild(child);
    }

    @Override
    public void setCollider(BaseCollider collider) {
        gameObject.setCollider(collider);
    }

    @Override
    public BaseAbilities getAbilities() {
        return gameObject.getAbilities();
    }

    @Override
    public Drop getGame() {
        return gameObject.getGame();
    }

    @Override
    public boolean equals(GameObject obj) {
        return gameObject.equals(obj);
    }
}
