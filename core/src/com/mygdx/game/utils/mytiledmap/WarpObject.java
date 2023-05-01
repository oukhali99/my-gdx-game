package com.mygdx.game.utils.mytiledmap;

import com.badlogic.gdx.maps.MapObject;

public class WarpObject extends BaseMapObject {
    public WarpObject(MapObject mapObject) {
        super(mapObject);
    }

    public String getMapDestination() {
        return getProperty("MapDestination", String.class);
    }

    public String getWarpDestination() {
        return getProperty("WarpDestination", String.class);
    }
}
