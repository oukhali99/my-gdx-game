package com.mygdx.game.gameobjects.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.movement.MovementWASDDecorator;
import com.mygdx.game.components.renderer.RendererHealthBarDecorator;

public class Player extends Character {
    public Player(Drop game) {
        super(game);

        setMovement(new MovementWASDDecorator(getMovement()));

        setRenderer(new RendererHealthBarDecorator(getRenderer()));
    }

    public Player(Player player) {
        super(player);
    }

    public String getTexturePath() {
        return "bucket.png";
    }
}
