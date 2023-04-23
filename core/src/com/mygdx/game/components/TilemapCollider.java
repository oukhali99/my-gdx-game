package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class TilemapCollider extends Component {
    private TiledMap tiledMap;
    private MapLayers mapLayers;
    protected MapLayer collisionLayer;

    public TilemapCollider(Drop game, TiledMap tiledMap) {
        super(game);
        this.tiledMap = tiledMap;
    }

    @Override
    public void attachToGameObject(GameObject gameObject) {
        super.attachToGameObject(gameObject);

        // Get the fields
        mapLayers = tiledMap.getLayers();
        collisionLayer = mapLayers.get("Collision");

        for (MapObject mapObject : collisionLayer.getObjects()) {
            if (mapObject instanceof RectangleMapObject) {
                final RectangleMapObject rectangleMapObject = (RectangleMapObject) mapObject;
                Collider rectangleCollider = new Collider(game) {
                    @Override
                    public Rectangle getArea() {
                        return rectangleMapObject.getRectangle();
                    }
                };
                rectangleCollider.attachToGameObject(gameObject);
            }
        }
    }
}
