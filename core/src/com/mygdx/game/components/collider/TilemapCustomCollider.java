package com.mygdx.game.components.collider;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.CombinedRectangles;

public class TilemapCustomCollider extends CustomCollider {
    private TiledMap tiledMap;
    private MapLayers mapLayers;
    protected MapLayer collisionLayer;
    private CombinedRectangles combinedRectangles;

    public TilemapCustomCollider(Drop game, String tilemapPath) {
        super(game);
        this.combinedRectangles = new CombinedRectangles();

        // Load the tilemap
        TmxMapLoader loader = new TmxMapLoader();
        tiledMap = loader.load(tilemapPath);

        // Get the collision layer
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
    public Rectangle getArea(GameObject gameObject) {
        return combinedRectangles;
    }
}
