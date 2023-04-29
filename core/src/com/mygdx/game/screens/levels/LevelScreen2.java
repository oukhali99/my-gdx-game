package com.mygdx.game.screens.levels;

import com.mygdx.game.Drop;

public class LevelScreen2 extends LevelScreen {
    public LevelScreen2(Drop game, String warpEntryPoint) {
        super(game, warpEntryPoint);
    }

    @Override
    public String getTilemapPath() {
        return "map/map.tmx";
    }

    @Override
    public LevelScreen getLevelScreenDestinationForWarp(String destination, String warpExitName) {
        return new LevelScreen1(game, warpExitName);
    }
}
