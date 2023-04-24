package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseScreen implements Screen {
    protected final Drop game;
    protected List<GameObject> gameObjects;
    protected OrthographicCamera camera;

    public BaseScreen(Drop game) {
        this.game = game;
        this.gameObjects = new LinkedList<>();

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

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

        for (GameObject gameObject : gameObjects) {
            gameObject.postPostUpdate(delta);
        }

        preenDestroyedGameObjects();
    }

    private void preenDestroyedGameObjects() {
        List<GameObject> enabledGameObjects = new LinkedList<>();
        for (GameObject gameObject : gameObjects) {
            gameObject.preenDestroyedChildren();
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
        //music.play();
    }

    public void dispose() {
        for (GameObject gameObject : gameObjects) {
            gameObject.destroy();
        }
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    public void resize(int width, int height) {
        //camera.setToOrtho(false, width, height);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }
}
