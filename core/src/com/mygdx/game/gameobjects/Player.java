package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Movement;
import com.mygdx.game.components.Texture;

public class Player extends GameObject {
    public Player(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        addComponent(new Movement(game, 8));
        addComponent(new Collider(game) {
            @Override
            public void onCollision(GameObject otherObject) {
                System.out.println("Collided with " + gameObject);
            }
        });
        addComponent(new Texture(game, "bucket.png"));
    }
}
