package com.mygdx.game.utils.mytiledmap;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
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

    public List<WarpTile> getWarps() {
        List<WarpTile> warps = new LinkedList<>();

        MapLayer warpsLayer = tiledMap.getLayers().get("Warps");
        MapObjects objects = warpsLayer.getObjects();
        for (MapObject object : objects) {
            warps.add(new WarpTile(object));
        }

        return warps;
    }

    public Map<String, WarpExitTile> getWarpExits() {
        Map<String, WarpExitTile> warps = new HashMap<>();

        MapLayer warpsLayer = tiledMap.getLayers().get("WarpExit");
        MapObjects objects = warpsLayer.getObjects();
        for (MapObject object : objects) {
            WarpExitTile warpExit = new WarpExitTile(object);
            warps.put(warpExit.getName(), new WarpExitTile(object));
        }

        return warps;
    }

    public WarpExitTile getWarpExit(String name) {
        return getWarpExits().get(name);
    }

    public Tile getTileAt(Vector2 position) {
        MapLayer tileLayer = getTiledMap().getLayers().get("Tile Layer 1");
        MapObjects mapObjects = tileLayer.getObjects();

        for (MapObject mapObject : mapObjects) {
            Tile tile = new Tile(mapObject);
            if (tile.getPosition().epsilonEquals(position, 4)) {
                return tile;
            }
        }

        return null;
    }
}
