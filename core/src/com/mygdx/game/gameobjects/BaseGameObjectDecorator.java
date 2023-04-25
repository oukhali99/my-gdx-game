package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.BaseUpdater;

import java.util.List;

public class BaseGameObjectDecorator extends BaseGameObject implements GameObject {
    private GameObject gameObject;

    public BaseGameObjectDecorator(GameObject baseGameObject) {
        super(baseGameObject.getGame());
        this.gameObject = baseGameObject;
    }

    @Override
    public Renderer getRenderer() {
        return gameObject.getRenderer();
    }

    @Override
    public Vector2 getPosition() {
        return gameObject.getPosition();
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
    public BaseAbilities getAbilities() {
        return gameObject.getAbilities();
    }

    @Override
    public BaseUpdater getUpdater() {
        return gameObject.getUpdater();
    }

    @Override
    public GameObject getThis() {
        return gameObject;
    }
}
