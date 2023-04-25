package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public abstract class BaseCollider extends BaseComponent {

    public BaseCollider(Drop game) {
        super(game);
    }

    public abstract void onCollision(GameObject otherObject);

    public abstract void postUpdate(float delta, List<GameObject> baseGameObjects, GameObject baseGameObject);

    public abstract void postPostUpdate(float delta);

    public abstract Rectangle getArea();
}
