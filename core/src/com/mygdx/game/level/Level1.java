package com.mygdx.game.level;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Drop;

public class Level1 extends Level {
    public Level1(Drop game) {
        super(game);
    }

    @Override
    public String getTilemapPath() {
        return "map/map.tmx";
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        camera.position.set(new Vector3(player.getTransform().getPosition(), 0));
    }

    @Override
    public void show() {
        super.show();
    }
}
