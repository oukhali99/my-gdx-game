package com.mygdx.game.utils.mytiledmap.mapcell;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class MapCellGrass extends MapCell {
    public MapCellGrass(TiledMapTileLayer.Cell cell, Vector2 gridPosition, TiledMapTileLayer layer) {
        super(cell, gridPosition, layer);
    }

    @Override
    public String getCombatTexturePath() {
        return "academybasement.gif";
    }
}
