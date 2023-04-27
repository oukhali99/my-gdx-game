package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.utils.MyTiledMap;

public class Player extends BaseCharacter {
    public Player(Drop game, MyTiledMap tiledMap) {
        super(game);

        baseUpdater = new WASDMovement(baseUpdater, 128);
    }

    @Override
    public String getTexturePath() {
        return "bucket.png";
    }
}
