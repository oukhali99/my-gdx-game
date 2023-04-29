package com.mygdx.game.components.collider;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.CombinedRectangles;
import com.mygdx.game.utils.MyTiledMap;

public class TilemapCustomCollider extends BaseCollider {
    protected MapLayer collisionLayer;
    private final MyTiledMap tiledMap;
    private final MapLayers mapLayers;
    private final CombinedRectangles combinedRectangles;

    public TilemapCustomCollider(Drop game, GameObject gameObject, MyTiledMap tiledMap) {
        super(game, gameObject);
        this.combinedRectangles = new CombinedRectangles();
        this.tiledMap = tiledMap;

        // Get the collision layer
        mapLayers = tiledMap.getTiledMap().getLayers();
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

    @Override
    public void handleCollision(GameObject otherGameObject) {
    }
}
