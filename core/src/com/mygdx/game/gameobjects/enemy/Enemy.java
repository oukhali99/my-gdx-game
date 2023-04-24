package com.mygdx.game.gameobjects.enemy;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Texture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.Player;
import com.mygdx.game.utils.Logger;

public class Enemy extends GameObject {
    public Enemy(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        addComponent(new Texture(game, getTexturePath()));

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run() {
                if (gameObject instanceof Player) {
                    markForDestruction();
                }
            }
        });
        addComponent(collider);
    }

    protected String getTexturePath() {
        return "droplet.png";
    }
}
