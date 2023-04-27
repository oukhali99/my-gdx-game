package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.utils.MyTiledMap;

public class Player extends BaseCharacter {
    public Player(Drop game, MyTiledMap tiledMap) {
        super(game);
    }

    @Override
    public String getTexturePath() {
        return "bucket.png";
    }

    @Override
    public Updater getUpdater() {
        return new WASDMovement(super.getUpdater(), 128);
    }
}
