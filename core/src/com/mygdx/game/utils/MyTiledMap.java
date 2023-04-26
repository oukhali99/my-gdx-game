package com.mygdx.game.utils;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

public class MyTiledMap {
    private TiledMap tiledMap;

    public MyTiledMap(String path) {
        TmxMapLoader loader = new TmxMapLoader();
        this.tiledMap = loader.load(path);
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public void dispose() {
        tiledMap.dispose();
    }

    public Vector2 getIndividualTileSize() {
        return getIntegerProperty("tilewidth", "tileheight");
    }

    public Vector2 getSizeInTiles() {
        return getIntegerProperty("width", "height");
    }

    public Vector2 getSizeInPixels() {
        Vector2 individualTileSize = getIndividualTileSize();
        Vector2 sizeInTiles = getSizeInTiles();
        return new Vector2(
                individualTileSize.x * sizeInTiles.x,
                individualTileSize.y * sizeInTiles.y
        );
    }

    private Vector2 getIntegerProperty(String propertyX, String propertyY) {
        return new Vector2(
                getTiledMap().getProperties().get(propertyX, Integer.class),
                getTiledMap().getProperties().get(propertyY, Integer.class)
        );
    }
}
