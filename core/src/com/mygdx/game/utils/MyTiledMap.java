package com.mygdx.game.utils;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

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
}
