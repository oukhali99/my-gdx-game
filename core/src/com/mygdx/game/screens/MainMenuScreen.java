package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.characters.Player;
import com.mygdx.game.gameobjects.characters.enemy.AlienEnemy;
import com.mygdx.game.utils.mytiledmap.MyTiledMap;

public class MainMenuScreen extends BaseScreen {

    public MainMenuScreen(final Drop game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            //game.setScreen(new LevelScreen1(game, "PlayerSpawn"));
            game.setScreen(new CombatScreen(
                    game,
                    this,
                    new CombatScreen.Fight(
                            new Player(game),
                            new AlienEnemy(game)
                    ),
                    new MyTiledMap("map/map2.tmx")
            ));
            dispose();
        }
    }
}
