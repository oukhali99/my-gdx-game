package com.mygdx.game.utils;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
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

    public List<Warp> getWarps() {
        List<Warp> warps = new LinkedList<>();

        MapLayer warpsLayer = tiledMap.getLayers().get("Warps");
        MapObjects objects = warpsLayer.getObjects();
        for (MapObject object : objects) {
            warps.add(new Warp(object));
        }

        return warps;
    }

    public Map<String, WarpExit> getWarpExits() {
        Map<String, WarpExit> warps = new HashMap<>();

        MapLayer warpsLayer = tiledMap.getLayers().get("WarpExit");
        MapObjects objects = warpsLayer.getObjects();
        for (MapObject object : objects) {
            WarpExit warpExit = new WarpExit(object);
            warps.put(warpExit.getName(), new WarpExit(object));
        }

        return warps;
    }

    public WarpExit getWarpExit(String name) {
        for (String warpExitName : getWarpExits().keySet()) {
            if (name.equals(warpExitName)) {
                return getWarpExits().get(warpExitName);
            }
        }
        return null;
    }

    private static Rectangle getMapObjectRectangle(MapObject mapObject) {
        float x = mapObject.getProperties().get("x", Float.class);
        float y = mapObject.getProperties().get("y", Float.class);
        float width = mapObject.getProperties().get("width", Float.class);
        float height = mapObject.getProperties().get("height", Float.class);
        return new Rectangle(x, y, width, height);
    }

    public static class Warp {
        private Rectangle rectangle;

        private String mapDestination;

        private String warpDestination;

        public Warp(MapObject mapObject) {
            this.rectangle = getMapObjectRectangle(mapObject);
            this.mapDestination = mapObject.getProperties().get("MapDestination", String.class);
            this.warpDestination = mapObject.getProperties().get("WarpDestination", String.class);
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

        public String getMapDestination() {
            return mapDestination;
        }

        public String getWarpDestination() {
            return warpDestination;
        }
    }

    public static class WarpExit {
        private Rectangle rectangle;

        private String name;

        public WarpExit(MapObject mapObject) {
            this.rectangle = getMapObjectRectangle(mapObject);
            this.name = mapObject.getProperties().get("Name", String.class);
        }

        public String getName() {
            return name;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

        public Vector2 getPosition() {
            return new Vector2(rectangle.x, rectangle.y);
        }
    }
}
