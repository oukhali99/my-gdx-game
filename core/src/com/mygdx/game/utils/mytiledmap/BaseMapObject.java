package com.mygdx.game.utils.mytiledmap;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;

public abstract class BaseMapObject extends BaseMapEntity {
    protected MapObject mapObject;

    public BaseMapObject(MapObject mapObject) {
        super();
        this.mapObject = mapObject;
    }

    @Override
    protected MapProperties getProperties() {
        return mapObject.getProperties();
    }
}
