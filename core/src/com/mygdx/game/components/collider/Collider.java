package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public interface Collider extends Component {
    public void onCollision(GameObject otherObject);

    public void postUpdate(float delta, List<GameObject> gameObjects, GameObject gameObject);

    public void postPostUpdate(GameObject gameObject, float delta);

    public Rectangle getArea(GameObject gameObject);
}
