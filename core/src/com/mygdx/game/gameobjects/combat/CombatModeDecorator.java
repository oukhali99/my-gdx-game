package com.mygdx.game.gameobjects.combat;

import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.gameobjects.BaseGameObjectDecorator;
import com.mygdx.game.gameobjects.GameObject;

public class CombatModeDecorator extends BaseGameObjectDecorator {
    public CombatModeDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public Renderer getRenderer() {
        return super.getRenderer();
    }
}
