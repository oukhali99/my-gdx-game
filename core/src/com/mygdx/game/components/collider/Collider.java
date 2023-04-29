package com.mygdx.game.components.collider;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public interface Collider extends Component {
    Rectangle getArea();

    LinkedList<GameObject> getCollisionObjectsThisFrame();

    void handleCollision(GameObject otherGameObject);

    void lookForCollisions(float delta, List<GameObject> gameObjects);
}
