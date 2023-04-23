package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.components.Collider;
import com.mygdx.game.components.Component;

import java.util.LinkedList;
import java.util.List;

public class GameScreen implements Screen {
    private final Drop game;
    private Music rainMusic;
    private OrthographicCamera camera;
    private long lastDropTime;
    private int dropsGathered;
    private List<GameObject> gameObjects;

    public GameScreen(final Drop game) {
        this.game = game;
        this.gameObjects = new LinkedList<>();

        // load the drop sound effect and the rain background "music"
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create bucket
        GameObject bucket = new GameObject(game) {
            @Override
            public void update(float delta) {
                super.update(delta);

                float x = getTransform().getPosition().x;

                // process user input
                if (Gdx.input.isTouched()) {
                    Vector3 touchPos = new Vector3();
                    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                    camera.unproject(touchPos);
                    x = touchPos.x - getTransform().getScale().x / 2;
                }

                // make sure the bucket stays within the screen bounds
                if (x < 0)
                    x = 0;
                if (x > 800 - getTransform().getScale().x)
                    x = 800 - getTransform().getScale().x;

                setPosition(x, getTransform().getPosition().y);
            }

            @Override
            protected String getTexturePath() {
                return "bucket.png";
            }
        };
        bucket.setPosition(800 / 2 - 64 / 2, 20);
        bucket.setScale(64, 64);

        // Create the bucket collider
        Component collider = new Collider() {
            private Sound dropSound;

            @Override
            public void initialize() {
                super.initialize();
                dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
            }

            @Override
            public void onCollision(GameObject otherObject) {
                dropSound.play();
            }
        };
        bucket.addComponent(collider);

        // Add the bucket to the game object list
        gameObjects.add(bucket);

        // create the raindrops array and spawn the first raindrop
        spawnRaindrop();
    }

    private void spawnRaindrop() {
        GameObject raindrop = new GameObject(game) {
            @Override
            public void update(float delta) {
                super.update(delta);
                transform.translate(0, -200 * Gdx.graphics.getDeltaTime());

                float y = getTransform().getPosition().y;
                float height = getTransform().getScale().y;
                if (y < 0 - height) {
                    markForDestruction();
                }
            }

            @Override
            protected String getTexturePath() {
                return "droplet.png";
            }
        };

        // Set the position and scale
        raindrop.setPosition(MathUtils.random(0, 800 - 64), 480);
        raindrop.setScale(64, 64);

        // Add collision component
        Component collider = new Collider() {
            @Override
            public void onCollision(GameObject otherObject) {
                gameObject.markForDestruction();
                dropsGathered++;
            }
        };
        raindrop.addComponent(collider);

        // Add to list
        gameObjects.add(raindrop);

        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
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
        game.font.draw(game.batch, "Drops Collected: " + dropsGathered, 0, 480);
        for (GameObject gameObject : gameObjects) {
            gameObject.render(delta);
        }
        game.batch.end();


        // check if we need to create a new raindrop
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            spawnRaindrop();

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

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        //rainMusic.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        rainMusic.dispose();
    }
}
