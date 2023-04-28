package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public interface Collider extends Component {
    public void lookForCollisions(float delta, List<GameObject> gameObjects);

    public void handleCollisionsThisFrame(float delta);

    public Rectangle getArea();

    public LinkedList<GameObject> getCollisionObjectsThisFrame();

    public void handleCollision(GameObject otherGameObject);
}
