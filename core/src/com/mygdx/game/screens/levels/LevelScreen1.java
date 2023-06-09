package com.mygdx.game.screens.levels;

import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.combat.enemy.EnemyFactory;

import java.util.Random;

public class LevelScreen1 extends LevelScreen {
    public LevelScreen1(Drop game) {
        super(game);

        for (int i = 0; i < 10; i++) {
            BaseGameObject enemy = EnemyFactory.createRandomEnemy(game);
            baseGameObjects.add(enemy);

            Random random = new Random();
            int max = 40;
            int min = 5;
            int x = random.nextInt(max - min + 1) + min;
            int y = random.nextInt(max - min + 1) + min;

            enemy.setPosition(16 * x, 16 * y);
        }
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
