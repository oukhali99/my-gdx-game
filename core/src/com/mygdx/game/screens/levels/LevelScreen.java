package com.mygdx.game.screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.TilemapCustomCollider;
import com.mygdx.game.components.renderer.TilemapRenderer;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Player;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.utils.MyTiledMap;

import java.util.LinkedList;

public abstract class LevelScreen extends BaseScreen {
    protected GameObject player;
    private Music music;
    private MyTiledMap myTiledMap;

    public LevelScreen(Drop game) {
        super(game);

        // load the drop sound effect and the rain background "music"
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);


        // Create the tilemap
        GameObject tileMapGameObject = new BaseGameObject(game) {
        };
        addGameObject(tileMapGameObject);

        // Load the tiled map
        myTiledMap = new MyTiledMap(getTilemapPath());

        // Actual tilemap component
        tileMapGameObject.setRenderer(new TilemapRenderer(game, camera, myTiledMap));

        tileMapGameObject.setCollider(new TilemapCustomCollider(game, myTiledMap));

        // Create the player
        player = new Player(game, myTiledMap);
        addGameObject(player);

        // Move the player to the center
        player.setPosition(myTiledMap.getPlayerSpawn());
    }

    public abstract String getTilemapPath();

    public void show() {
        super.show();
        //music.play();
    }

    public void dispose() {
        super.dispose();
        for (GameObject gameObject : getGameObjects()) {
            gameObject.destroy();
        }
        music.dispose();
        myTiledMap.dispose();
    }

    public void resize(int width, int height) {
        super.resize(width, height);
        //camera.setToOrtho(false, width, height);
    }
}
