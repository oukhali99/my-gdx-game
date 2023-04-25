package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseScreen implements Screen {
    protected final Drop game;
    protected List<GameObject> baseGameObjects;
    protected OrthographicCamera camera;

    public BaseScreen(Drop game) {
        this.game = game;
        this.baseGameObjects = new LinkedList<>();

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
    }

    protected BitmapFont getFont() {
        return new BitmapFont();
    }

    public int getGameObjectCountIncludingChildren() {
        int count = 0;

        for (GameObject baseGameObject : baseGameObjects) {
            count += baseGameObject.getChildren().size() + 1;
        }

        return count;
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
        for (GameObject baseGameObject : baseGameObjects) {
            baseGameObject.render(delta);
        }
        game.batch.end();

        for (GameObject baseGameObject : baseGameObjects) {
            baseGameObject.update(delta);
        }

        for (GameObject baseGameObject : baseGameObjects) {
            baseGameObject.postUpdate(delta);
        }

        for (GameObject baseGameObject : baseGameObjects) {
            baseGameObject.postPostUpdate(delta);
        }

        preenDestroyedGameObjects();


        game.batch.setProjectionMatrix(new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        game.batch.begin();
        //getFont().draw(game.batch, "GameObject count " + getGameObjectCountIncludingChildren(), 1000, 700);
        game.batch.end();
    }

    private void preenDestroyedGameObjects() {
        List<GameObject> enabledBaseGameObjects = new LinkedList<>();
        for (GameObject baseGameObject : baseGameObjects) {
            baseGameObject.preenDestroyedChildren();
            if (baseGameObject.isMarkedForDestruction()) {
                baseGameObject.destroy();
            }
            else {
                enabledBaseGameObjects.add(baseGameObject);
            }
        }
        baseGameObjects = enabledBaseGameObjects;
    }

    public void show() {
        // start the playback of the background music
        // when the screen is shown
        //music.play();
    }

    public void dispose() {
        for (GameObject baseGameObject : baseGameObjects) {
            baseGameObject.destroy();
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
        return baseGameObjects;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
