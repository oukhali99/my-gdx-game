package com.mygdx.game.utils.mytiledmap;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MapCell extends BaseMapEntity {
    private final TiledMapTileLayer.Cell cell;
    private final Vector2 gridPosition;
    private final TiledMapTileLayer layer;

    public MapCell(TiledMapTileLayer.Cell cell, Vector2 gridPosition, TiledMapTileLayer layer) {
        this.cell = cell;
        this.gridPosition = gridPosition;
        this.layer = layer;
    }

    @Override
    public Rectangle getRectangle() {
        float cellX = gridPosition.x;
        float cellY = gridPosition.y;

        float cellXPixel = cellX * layer.getTileWidth();
        float cellYPixel = cellY * layer.getTileHeight();

        float scaleXPixel = layer.getTileWidth() / cell.getTile().getTextureRegion().getRegionWidth();
        float scaleYPixel = layer.getTileHeight() / cell.getTile().getTextureRegion().getRegionHeight();

        return new Rectangle(cellXPixel, cellYPixel, scaleXPixel, scaleYPixel);
    }

    @Override
    protected MapProperties getProperties() {
        return cell.getTile().getProperties();
    }
}
