package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.Updater;

import java.util.List;

public class GameObjectDecorator implements GameObject {
    private GameObject baseGameObject;

    public GameObjectDecorator(GameObject baseGameObject) {
        this.baseGameObject = baseGameObject;
    }

    public Renderer getRenderer() {
        return baseGameObject.getRenderer();
    }

    public void setPosition(float x, float y) {
        baseGameObject.setPosition(x, y);
    }

    public void setPosition(Vector2 position) {
        baseGameObject.setPosition(position);
    }

    public Vector2 getPosition() {
        return getTransform().getPosition();
    }

    public void setScale(float x, float y) {
        baseGameObject.setScale(x, y);
    }

    public void setScale(Vector2 scale) {
        baseGameObject.setScale(scale);
    }

    public Vector2 getScale() {
        return getTransform().getScale();
    }

    public Collider getCollider() {
        return baseGameObject.getCollider();
    }

    public Transform getTransform() {
        return baseGameObject.getTransform();
    }

    public boolean isMarkedForDestruction() {
        return baseGameObject.isMarkedForDestruction();
    }

    public void markForDestruction() {
        baseGameObject.markForDestruction();
    }

    public void destroy() {
        baseGameObject.destroy();
    }

    public void preenDestroyedChildren() {
        baseGameObject.preenDestroyedChildren();
    }

    public List<GameObject> getChildren() {
        return baseGameObject.getChildren();
    }

    public void addChild(GameObject child) {
        baseGameObject.addChild(child);
    }

    public Drop getGame() {
        return baseGameObject.getGame();
    }

    @Override
    public void onCollision(GameObject givenGameObject, GameObject otherGameObject) {
        baseGameObject.onCollision(givenGameObject, otherGameObject);
    }

    @Override
    public void translate(Vector2 amount) {
        baseGameObject.translate(amount);
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        baseGameObject.render(gameObject, delta);
    }

    @Override
    public void update(GameObject gameObject, float delta) {
        baseGameObject.update(gameObject, delta);
    }

    @Override
    public void postUpdate(float delta, List<GameObject> gameObjects, GameObject gameObject) {
        baseGameObject.postUpdate(delta, gameObjects, gameObject);
    }

    @Override
    public void postPostUpdate(GameObject gameObject, float delta) {
        baseGameObject.postPostUpdate(gameObject, delta);
    }

    @Override
    public List<GameObject> getCollisionObjectsThisFrame() {
        return baseGameObject.getCollisionObjectsThisFrame();
    }

    @Override
    public void clearCollisionObjectsThisFrame() {
        baseGameObject.clearCollisionObjectsThisFrame();
    }

    @Override
    public void addCollisionObjectThisFrame(GameObject gameObject) {
        baseGameObject.addCollisionObjectThisFrame(gameObject);
    }
}
