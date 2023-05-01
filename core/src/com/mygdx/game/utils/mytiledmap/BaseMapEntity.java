package com.mygdx.game.utils.mytiledmap;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseMapEntity {

    protected <T> T getProperty(String key, Class<T> clazz) {
        MapProperties mapProperties = getProperties();

        if (mapProperties.containsKey(key)) {
            return mapProperties.get(key, clazz);
        }

        return null;
    }

    public Rectangle getRectangle() {
        float x = getProperty("x", Float.class);
        float y = getProperty("y", Float.class);
        float width = getProperty("width", Float.class);
        float height = getProperty("height", Float.class);
        return new Rectangle(x, y, width, height);
    }

    public Vector2 getPosition() {
        Rectangle rectangle = getRectangle();
        return new Vector2(rectangle.x, rectangle.y);
    }

    public String getName() {
        String name = getProperty("Name", String.class);

        if (name != null) {
            return name;
        }
        return "";
    }

    protected abstract MapProperties getProperties();
}
