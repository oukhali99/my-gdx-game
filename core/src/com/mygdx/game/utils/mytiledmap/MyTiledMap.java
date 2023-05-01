package com.mygdx.game.utils.mytiledmap;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

    public List<WarpObject> getWarps() {
        List<WarpObject> warps = new LinkedList<>();

        MapLayer warpsLayer = tiledMap.getLayers().get("Warps");
        MapObjects objects = warpsLayer.getObjects();
        for (MapObject object : objects) {
            warps.add(new WarpObject(object));
        }

        return warps;
    }

    public Map<String, WarpExitObject> getWarpExits() {
        Map<String, WarpExitObject> warps = new HashMap<>();

        MapLayer warpsLayer = tiledMap.getLayers().get("WarpExit");
        MapObjects objects = warpsLayer.getObjects();
        for (MapObject object : objects) {
            WarpExitObject warpExit = new WarpExitObject(object);
            warps.put(warpExit.getName(), new WarpExitObject(object));
        }

        return warps;
    }

    public WarpExitObject getWarpExit(String name) {
        return getWarpExits().get(name);
    }

    public MapCell getTileAt(Vector2 position) {
        TiledMapTileLayer tileLayer = (TiledMapTileLayer) getTiledMap().getLayers().get("Tile Layer 1");

        for (int i = 0; i < tileLayer.getWidth(); i++) {
            for (int j = 0; j < tileLayer.getHeight(); j++) {
                TiledMapTileLayer.Cell cell = tileLayer.getCell(i, j);
                MapCell mapEntity = new MapCell(cell, new Vector2(i, j), tileLayer);

                if (mapEntity.getPosition().epsilonEquals(position, 4)) {
                    return mapEntity;
                }
            }
        }

        return null;
    }
}
