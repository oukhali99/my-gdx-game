package com.mygdx.game.screens.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Drop;
import com.mygdx.game.components.tilemap.Tilemap;
import com.mygdx.game.components.collider.TilemapCollider;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.combatactors.Player;
import com.mygdx.game.screens.BaseScreen;

import java.util.LinkedList;

public abstract class LevelScreen extends BaseScreen {
    protected GameObject player;
    private Music music;

    public LevelScreen(Drop game) {
        super(game);
        this.gameObjects = new LinkedList<>();

        // load the drop sound effect and the rain background "music"
        music = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        music.setLooping(true);


        // Create the tilemap
        GameObject tileMap = new GameObject(game) {
        };

        // Actual tilemap component
        Tilemap tilemapComponent = new Tilemap(game, camera, getTilemapPath());
        tileMap.addComponent(tilemapComponent);

        // Collider component
        TilemapCollider tilemapCollider = new TilemapCollider(game, tilemapComponent.getMap()) {
            @Override
            public void destroy() {
                super.destroy();
                shapeRenderer.dispose();
            }

            private ShapeRenderer shapeRenderer = new ShapeRenderer();

            @Override
            public void update(float delta) {
                super.update(delta);

                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

                // Set the color to red
                shapeRenderer.setColor(Color.RED);

                // Draw a rectangle at position (x=100, y=100) with width=100 and height=50
                for (MapObject mapObject : collisionLayer.getObjects()) {
                    if (mapObject instanceof RectangleMapObject) {
                        RectangleMapObject rectangleMapObject = (RectangleMapObject) mapObject;
                        Rectangle rectangle = rectangleMapObject.getRectangle();

                        Vector3 rectPos = new Vector3(rectangle.x, rectangle.y, 0);
                        camera.project(rectPos);

                        //shapeRenderer.rect(rectPos.x, rectPos.y, rectangle.width, rectangle.height);
                    }
                }

                // End the shape renderer
                shapeRenderer.end();
            }
        };
        tileMap.addComponent(tilemapCollider);

        gameObjects.add(tileMap);


        // Create the player
        player = new Player(game);
        gameObjects.add(player);
    }

    public abstract String getTilemapPath();

    public void show() {
        super.show();
        //music.play();
    }

    public void dispose() {
        super.dispose();
        for (GameObject gameObject : gameObjects) {
            gameObject.destroy();
        }
        music.dispose();
    }

    public void resize(int width, int height) {
        super.resize(width, height);
        //camera.setToOrtho(false, width, height);
    }
}
