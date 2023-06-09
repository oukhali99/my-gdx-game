package com.mygdx.game.screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.TilemapCustomCollider;
import com.mygdx.game.components.renderer.Tilemap;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.Player;
import com.mygdx.game.screens.BaseScreen;

import java.util.LinkedList;

public abstract class LevelScreen extends BaseScreen {
    protected BaseGameObject player;
    private Music music;

    public LevelScreen(Drop game) {
        super(game);
        this.baseGameObjects = new LinkedList<>();

        // load the drop sound effect and the rain background "music"
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);


        // Create the tilemap
        BaseGameObject tileMap = new BaseGameObject(game) {
        };

        // Actual tilemap component
        tileMap.setRenderer(new Tilemap(game, camera, getTilemapPath()));

        tileMap.setCollider(new TilemapCustomCollider(game, getTilemapPath()) {
            @Override
            public CollisionRunnable getOnCollisionRunnable() {
                return new CollisionRunnable() {
                    @Override
                    public void run(GameObject otherBaseGameObject) {
                    }
                };
            }
        });

        baseGameObjects.add(tileMap);


        // Create the player
        player = new Player(game);
        baseGameObjects.add(player);
    }

    public abstract String getTilemapPath();

    public void show() {
        super.show();
        //music.play();
    }

    public void dispose() {
        super.dispose();
        for (GameObject gameObject : baseGameObjects) {
            gameObject.destroy();
        }
        music.dispose();
    }

    public void resize(int width, int height) {
        super.resize(width, height);
        //camera.setToOrtho(false, width, height);
    }
}
