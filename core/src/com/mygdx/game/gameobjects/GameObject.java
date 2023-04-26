package com.mygdx.game.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.BaseAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.updater.Updater;

import java.util.List;

public interface GameObject {
    public Renderer getRenderer();

    public void setRenderer(Renderer renderer);

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

    public void preenDestroyedChildren();

    public List<GameObject> getChildren();

    public void addChild(GameObject child);

    public void setCollider(BaseCollider collider);

    public BaseAbilities getAbilities();

    public void setAbilities(BaseAbilities abilities);

    public Drop getGame();

    public Updater getUpdater();

    public void onCollision(GameObject gameObject, GameObject otherGameObject);
}
