package com.mygdx.game.components.collider;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.CombinedRectangles;
import com.mygdx.game.utils.mytiledmap.MyTiledMap;

public class TilemapCustomCollider extends BaseCollider {
    protected MapLayer collisionLayer;
    private final MyTiledMap tiledMap;
    private MapLayers mapLayers;
    private final CombinedRectangles combinedRectangles;
    private final String layerName;

    public TilemapCustomCollider(Drop game, GameObject gameObject, MyTiledMap tiledMap, String layerName) {
        super(game, gameObject);
        this.combinedRectangles = new CombinedRectangles();
        this.tiledMap = tiledMap;
        this.layerName = layerName;

        generateCollider();
    }

    private void generateCollider() {
        // Get the collision layer
        mapLayers = tiledMap.getTiledMap().getLayers();
        collisionLayer = mapLayers.get(layerName);

        // Generate the combined rectangles
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
