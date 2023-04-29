package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.gameobjects.GameObject;

public class RectangleCollider extends Collider {
    public RectangleCollider(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
    }

    @Override
    protected Rectangle getArea() {
        Transform transform = getGameObject().getTransform();
        Rectangle rectangle = new Rectangle();
        rectangle.x = transform.getPosition().x;
        rectangle.y = transform.getPosition().y;
        rectangle.width = transform.getScale().x;
        rectangle.height = transform.getScale().y;
        return rectangle;
    }
}
