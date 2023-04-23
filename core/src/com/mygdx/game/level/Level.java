package com.mygdx.game.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Tilemap;
import com.mygdx.game.components.TilemapCollider;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.Player;

import java.util.LinkedList;
import java.util.List;

public abstract class Level {
    private final Drop game;
    protected GameObject player;
    private List<GameObject> gameObjects;
    private Music music;
    protected OrthographicCamera camera;

    public Level(Drop game) {
        this.game = game;
        this.gameObjects = new LinkedList<>();

        initialize();
    }

    public void initialize() {
        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);

        // load the drop sound effect and the rain background "music"
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);

        // Create the tilemap
        GameObject tileMap = new GameObject(game) {
        };
        Tilemap tilemapComponent = new Tilemap(game, camera, "map/map.tmx");
        tileMap.addComponent(tilemapComponent);
        tileMap.addComponent(new TilemapCollider(game, tilemapComponent.getMap()));
        gameObjects.add(tileMap);

        // Create the player
        player = new Player(game);
        gameObjects.add(player);
    }

    public abstract String getTilemapPath();

    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to clear are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        game.batch.begin();
        for (GameObject gameObject : gameObjects) {
            gameObject.render(delta);
        }
        game.batch.end();

        for (GameObject gameObject : gameObjects) {
            gameObject.update(delta);
        }

        for (GameObject gameObject : gameObjects) {
            gameObject.postUpdate(delta);
        }

        preenDestroyedGameObjects();
    }

    private void preenDestroyedGameObjects() {
        List<GameObject> enabledGameObjects = new LinkedList<>();
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isMarkedForDestruction()) {
                gameObject.destroy();
            }
            else {
                enabledGameObjects.add(gameObject);
            }
        }
        gameObjects = enabledGameObjects;
    }

    public void show() {
        // start the playback of the background music
        // when the screen is shown
        //rainMusic.play();
    }

    public void dispose() {
        for (GameObject gameObject : gameObjects) {
            gameObject.destroy();
        }
        music.dispose();
    }

    public void resize(int width, int height) {
        //camera.setToOrtho(false, width, height);
    }
}
