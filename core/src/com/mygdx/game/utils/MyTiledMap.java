package com.mygdx.game.utils;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.Map;

public class MyTiledMap {
    private final TiledMap tiledMap;
    private final Map<String, Vector2> spawns;

    public MyTiledMap(String path) {
        TmxMapLoader loader = new TmxMapLoader();
        this.tiledMap = loader.load(path);
        this.spawns = new HashMap<>();

        loadSpawns();
    }

    private void loadSpawns() {
        MapLayer spawnPointsLayer = tiledMap.getLayers().get("Spawns");
        MapObjects objects = spawnPointsLayer.getObjects();
        for (MapObject object : objects) {
            if (object.getProperties().containsKey("SpawnFor")) {
                String spawnFor = object.getProperties().get("SpawnFor", String.class);
                float spawnX = object.getProperties().get("x", Float.class);
                float spawnY = object.getProperties().get("y", Float.class);

                spawns.put(spawnFor, new Vector2(spawnX, spawnY));
            }
        }
    }

    public Vector2 getPlayerSpawn() {
        return spawns.get("Player");
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
