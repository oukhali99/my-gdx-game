package com.mygdx.game.screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Drop;
import com.mygdx.game.components.collider.ColliderWarp;
import com.mygdx.game.components.collider.TilemapCustomCollider;
import com.mygdx.game.components.renderer.TilemapRenderer;
import com.mygdx.game.components.transform.BasicTransform;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.characters.Player;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.utils.Logger;
import com.mygdx.game.utils.MyTiledMap;

public abstract class LevelScreen extends BaseScreen {
    protected GameObject player;
    private Music music;
    private MyTiledMap myTiledMap;

    public LevelScreen(Drop game, String warpExitName) {
        super(game);
        initialize(warpExitName);
    }

    private void initialize(String warpExitName) {
        // load the drop sound effect and the rain background "music"
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);

        // Load the tiled map
        myTiledMap = new MyTiledMap(getTilemapPath());

        // Create the tilemap
        GameObject tileMapGameObject = new GameObject(game) {
        };
        tileMapGameObject.setRenderer(new TilemapRenderer(game, tileMapGameObject, camera, myTiledMap));
        tileMapGameObject.setCollider(new TilemapCustomCollider(game, tileMapGameObject, myTiledMap, "Collision"));
        addGameObject(tileMapGameObject);

        // Create the warp map
        for (MyTiledMap.Warp warp : myTiledMap.getWarps()) {
            GameObject warpObject = new GameObject(game) {};

            warpObject.setTransform(new BasicTransform(game, warpObject, warp.getRectangle()));

            warpObject.setCollider(new ColliderWarp(game, warpObject, warp, this));

            addGameObject(warpObject);
        }

        // Create the player
        player = new Player(game);
        addGameObject(player);

        if (myTiledMap.getWarpExit(warpExitName) != null) {
            player.setPosition(myTiledMap.getWarpExit(warpExitName).getPosition());
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        camera.position.set(new Vector3(player.getTransform().getPosition(), 0));
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

    public abstract LevelScreen getLevelScreenDestinationForWarp(String destination, String warpEntryPoint);

    public void onCollisionBetweenPlayerAndEnemy() {
        Logger.log("Fight");
    }
}
