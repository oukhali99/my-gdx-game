package com.mygdx.game.components.transform;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class BasicTransform extends BaseTransform {
    public BasicTransform(Drop game, GameObject gameObject) {
        super(game, gameObject);
    }

    public BasicTransform(Drop game, GameObject gameObject, Vector2 position, Vector2 scale, float rotation) {
        super(game, gameObject, position, scale, rotation);
    }

    public BasicTransform(Drop game, GameObject warpObject, Rectangle rectangle) {
        super(
                game,
                warpObject,
                new Vector2(rectangle.x, rectangle.y),
                new Vector2(rectangle.width, rectangle.height),
                0
        );
    }
}
