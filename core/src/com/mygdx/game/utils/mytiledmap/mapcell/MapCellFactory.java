package com.mygdx.game.utils.mytiledmap.mapcell;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class MapCellFactory {
    public static MapCell createMapCell(TiledMapTileLayer.Cell cell, Vector2 gridPosition, TiledMapTileLayer layer) {
        MapCell probationaryCell = new MapCellUnknown(cell, gridPosition, layer);

        switch (probationaryCell.getName()) {
            case "Grass":
                probationaryCell = new MapCellGrass(cell, gridPosition, layer);
                break;
            default:
                break;
        }

        return probationaryCell;
    }
}
