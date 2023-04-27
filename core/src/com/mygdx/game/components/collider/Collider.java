package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

import java.util.List;

public interface Collider extends Component {
    public void lookForCollisions(float delta, List<GameObject> gameObjects, GameObject gameObject);

    public void handleCollisionsThisFrame(GameObject gameObject, float delta);

    public Rectangle getArea(GameObject gameObject);
}
