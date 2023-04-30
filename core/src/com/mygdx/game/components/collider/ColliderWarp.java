package com.mygdx.game.components.collider;

import com.badlogic.gdx.Screen;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.characters.Player;
import com.mygdx.game.screens.LevelTransitionScreen;
import com.mygdx.game.screens.levels.LevelScreen;
import com.mygdx.game.utils.mytiledmap.WarpTile;

public class ColliderWarp extends RectangleCollider {
    private final WarpTile warp;
    private final LevelScreen levelScreen;

    public ColliderWarp(Drop game, GameObject gameObject, WarpTile warp, LevelScreen levelScreen) {
        super(game, gameObject);
        this.warp = warp;
        this.levelScreen = levelScreen;
    }

    @Override
    public void handleCollision(GameObject otherGameObject) {
        super.handleCollision(otherGameObject);

        if (otherGameObject instanceof Player) {
            Screen level = levelScreen.getLevelScreenDestinationForWarp(warp.getMapDestination(), warp.getWarpDestination());
            game.setScreen(new LevelTransitionScreen(game, level));
        }
    }
}
