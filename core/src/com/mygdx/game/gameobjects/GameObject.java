package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.BaseUpdater;
import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

public interface GameObject {
    public Renderer getRenderer();

    public void setRenderer(Renderer renderer);

    public void render(float delta);

    public void update(float delta);

    public void postUpdate(float delta);

    public void setPosition(float x, float y);

    public void setPosition(Vector2 position);

    public Vector2 getPosition();

    public void setScale(float x, float y);

    public void setScale(Vector2 scale);

    public Vector2 getScale();

    public BaseCollider getCollider();

    public Transform getTransform();

    public boolean isMarkedForDestruction();

    public void markForDestruction();

    public void destroy();

    public void postPostUpdate(float delta);

    public void preenDestroyedChildren();

    public List<BaseGameObject> getChildren();

    public void addChild(BaseGameObject child);

    public void setCollider(BaseCollider collider);

    public BaseAbilities getAbilities();

    public Drop getGame();

    public boolean equals(GameObject obj);

    public BaseUpdater getUpdater();

    public GameObject getThis();
}
