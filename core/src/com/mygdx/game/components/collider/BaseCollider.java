package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public abstract class BaseCollider extends BaseComponent implements Collider {

    public BaseCollider(Drop game) {
        super(game);
    }
}
