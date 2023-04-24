package com.mygdx.game.components;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.CombinedRectangles;

public class TilemapCollider extends Collider {
    private TiledMap tiledMap;
    private MapLayers mapLayers;
    protected MapLayer collisionLayer;
    private CombinedRectangles combinedRectangles;

    public TilemapCollider(Drop game, TiledMap tiledMap) {
        super(game);
        this.tiledMap = tiledMap;
        this.combinedRectangles = new CombinedRectangles();
    }

    @Override
    public void attachToGameObject(GameObject gameObject) {
        super.attachToGameObject(gameObject);

        // Get the fields
        mapLayers = tiledMap.getLayers();
        collisionLayer = mapLayers.get("Collision");

        for (MapObject mapObject : collisionLayer.getObjects()) {
            if (mapObject instanceof RectangleMapObject) {
                RectangleMapObject rectangleMapObject = (RectangleMapObject) mapObject;
                combinedRectangles.addRectangle(rectangleMapObject.getRectangle());
            }
        }
    }

    @Override
    public Rectangle getArea() {
        return combinedRectangles;
    }
}
