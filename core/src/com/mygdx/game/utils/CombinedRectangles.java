package com.mygdx.game.utils;

import com.badlogic.gdx.math.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class CombinedRectangles extends Rectangle {
    private List<Rectangle> rectanglesList;

    public CombinedRectangles() {
        this.rectanglesList = new LinkedList<>();
    }

    public void addRectangle(Rectangle rectangle) {
        rectanglesList.add(rectangle);
    }

    @Override
    public boolean overlaps(Rectangle r) {
        for (Rectangle rectangle : rectanglesList) {
            if (rectangle.overlaps(r)) {
                return true;
            }
        }

        return false;
    }
}
