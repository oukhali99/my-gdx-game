package com.mygdx.game.components;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.game.Drop;

public class TilemapCollider extends Collider {
    private TiledMap tiledMap;
    private MapLayers mapLayers;
    private TiledMapTileLayer collisionLayer;

    public TilemapCollider(Drop game) {
        super(game);
    }

    @Override
    public void postUpdate(float delta) {
        super.postUpdate(delta);
    }
}
