package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.MyTiledMap;

public class Player extends Character {
    public Player(Drop game, MyTiledMap tiledMap) {
        super(game);
    }

    public String getTexturePath() {
        return "bucket.png";
    }

    public Updater getUpdater() {
        return new WASDMovement(super.getUpdater(), 128);
    }
}
