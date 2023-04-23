package com.mygdx.game.components;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class Collider extends Component {
    private static List<Collider> allColliders = new LinkedList<>();

    @Override
    public void postUpdate(float delta) {
        super.postUpdate(delta);

        for (Collider collider : allColliders) {
            if (
                collider.getArea().overlaps(getArea()) &&
                this != collider
            ) {
                onCollision(collider.gameObject);
            }
        }
    }

    public Rectangle getArea() {
        Transform transform = gameObject.getTransform();
        Rectangle rectangle = new Rectangle();
        rectangle.x = transform.getPosition().x;
        rectangle.y = transform.getPosition().y;
        rectangle.width = transform.getScale().x;
        rectangle.height = transform.getScale().y;
        return rectangle;
    }

    @Override
    public void attachToGameObject(GameObject gameObject) {
        super.attachToGameObject(gameObject);
        allColliders.add(this);
    }

    @Override
    public void destroy() {
        super.destroy();
        allColliders.remove(this);
    }

    public abstract void onCollision(GameObject otherObject);
}
