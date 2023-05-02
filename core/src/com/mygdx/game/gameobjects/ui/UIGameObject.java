package com.mygdx.game.gameobjects.ui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class UIGameObject extends GameObject {
    protected final Stage stage;

    protected UIGameObject(Drop game, Stage stage) {
        super(game);
        this.stage = stage;
    }
}
