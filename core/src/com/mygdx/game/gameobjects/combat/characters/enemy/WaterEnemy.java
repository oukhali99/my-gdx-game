package com.mygdx.game.gameobjects.combat.characters.enemy;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.components.renderer.RendererColorDecorator;

public class WaterEnemy extends Enemy {
    public WaterEnemy(Drop game) {
        super(game);
    }

    @Override
    public String getTexturePath() {
        return "alien2.png";
    }
}
