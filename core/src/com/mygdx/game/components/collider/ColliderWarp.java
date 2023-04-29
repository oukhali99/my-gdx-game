package com.mygdx.game.components.collider;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.screens.levels.LevelScreen;
import com.mygdx.game.utils.MyTiledMap;

public class ColliderWarp extends RectangleCollider {
    private final MyTiledMap.Warp warp;
    private final LevelScreen levelScreen;

    public ColliderWarp(Drop game, GameObject gameObject, MyTiledMap.Warp warp, LevelScreen levelScreen) {
        super(game, gameObject);
        this.warp = warp;
        this.levelScreen = levelScreen;
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        super.handleCollision(otherGameObject);

        Screen level = levelScreen.getLevelScreenDestinationForWarp(warp.getMapDestination(), warp.getWarpDestination());
        game.setScreen(level);
    }
}
