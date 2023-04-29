package com.mygdx.game.screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.TilemapCustomCollider;
import com.mygdx.game.components.renderer.TilemapRenderer;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Player;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.utils.MyTiledMap;

public abstract class LevelScreen extends BaseScreen {
    protected GameObject player;
    private final Music music;
    private final MyTiledMap myTiledMap;

    public LevelScreen(Drop game) {
        super(game);

        // load the drop sound effect and the rain background "music"
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);

        // Load the tiled map
        myTiledMap = new MyTiledMap(getTilemapPath());

        // Create the tilemap
        GameObject tileMapGameObject = new GameObject(game) {
        };
        tileMapGameObject.setRenderer(new TilemapRenderer(game, tileMapGameObject, camera, myTiledMap));
        tileMapGameObject.setCollider(new TilemapCustomCollider(game, tileMapGameObject, myTiledMap));
        addGameObject(tileMapGameObject);

        // Create the player
        player = new Player(game);
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
