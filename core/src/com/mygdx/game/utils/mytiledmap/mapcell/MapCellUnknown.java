package com.mygdx.game.utils.mytiledmap.mapcell;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class MapCellUnknown extends MapCell {
    public MapCellUnknown(TiledMapTileLayer.Cell cell, Vector2 gridPosition, TiledMapTileLayer layer) {
        super(cell, gridPosition, layer);
    }

    @Override
    public String getCombatTexturePathExtension() {
        return "grass-plains.png";
    }

    @Override
    public Vector2 getCombatBasePosition() {
        return new Vector2();
    }
}
