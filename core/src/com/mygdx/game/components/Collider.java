package com.mygdx.game.components;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class Collider extends Component {
    private static List<Collider> allColliders = new LinkedList<>();
    private Rectangle rectangle;

    public Collider() {
        super();
        rectangle = new Rectangle();
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        for (Collider collider : allColliders) {
            if (
                collider.rectangle.overlaps(rectangle) &&
                this != collider
            ) {
                onCollision(collider.gameObject);
            }
        }
    }

    @Override
    public void onGameObjectChanged() {
        super.onGameObjectChanged();
        Transform transform = gameObject.getTransform();
        rectangle.x = transform.getPosition().x;
        rectangle.y = transform.getPosition().y;
        rectangle.width = transform.getScale().x;
        rectangle.height = transform.getScale().y;
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
