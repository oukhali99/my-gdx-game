package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.BaseUpdater;

import java.util.List;

public class GameObjectDecorator implements GameObject {
    private GameObject gameObject;

    public GameObjectDecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public Renderer getRenderer() {
        return gameObject.getRenderer();
    }

    public void setRenderer(Renderer renderer) {
        gameObject.setRenderer(renderer);
    }

    public void setPosition(float x, float y) {
        gameObject.setPosition(x, y);
    }

    public void setPosition(Vector2 position) {
        gameObject.setPosition(position);
    }

    public Vector2 getPosition() {
        return gameObject.getPosition();
    }

    public void setScale(float x, float y) {
        gameObject.setScale(x, y);
    }

    public void setScale(Vector2 scale) {
        gameObject.setScale(scale);
    }

    public Vector2 getScale() {
        return gameObject.getScale();
    }

    public BaseCollider getCollider() {
        return gameObject.getCollider();
    }

    public Transform getTransform() {
        return gameObject.getTransform();
    }

    public boolean isMarkedForDestruction() {
        return gameObject.isMarkedForDestruction();
    }

    public void markForDestruction() {
        gameObject.markForDestruction();
    }

    public void destroy() {
        gameObject.destroy();
    }

    public void preenDestroyedChildren() {
        gameObject.preenDestroyedChildren();
    }

    public List<GameObject> getChildren() {
        return gameObject.getChildren();
    }

    public void addChild(GameObject child) {
        gameObject.addChild(child);
    }

    public void setCollider(BaseCollider collider) {
        gameObject.setCollider(collider);
    }

    public BaseAbilities getAbilities() {
        return gameObject.getAbilities();
    }

    public Drop getGame() {
        return gameObject.getGame();
    }

    public BaseUpdater getUpdater() {
        return gameObject.getUpdater();
    }

    @Override
    public void onCollision(GameObject otherGameObject) {
        gameObject.onCollision(otherGameObject);
    }
}
