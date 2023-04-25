package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;

import java.util.List;

public class NoCollisions extends BaseCollider {
    public NoCollisions(Drop game) {
        super(game);
    }

    @Override
    public void onCollision(BaseGameObject otherObject) {

    }

    @Override
    public void postUpdate(float delta, List<BaseGameObject> baseGameObjects, BaseGameObject baseGameObject) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void postPostUpdate(float delta) {

    }

    @Override
    public Rectangle getArea() {
        return new Rectangle(0, 0, 0, 0);
    }
}
