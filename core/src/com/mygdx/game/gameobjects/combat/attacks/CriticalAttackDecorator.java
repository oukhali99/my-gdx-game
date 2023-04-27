package com.mygdx.game.gameobjects.combat.attacks;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.renderer.RendererDecorator;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.GameObjectDecorator;
import com.mygdx.game.screens.CombatScreen;

public class CriticalAttackDecorator extends GameObjectDecorator implements Attack {
    private Attack attack;
    private float flashFill;

    public CriticalAttackDecorator(Attack attack) {
        super(attack);
        this.attack = attack;
        this.flashFill = 0;

        setRenderer(new RendererDecorator(getRenderer()) {
            @Override
            public void render(GameObject gameObject, float delta) {
                Color originalColor = new Color(getGame().batch.getColor());
                if (flashFill > 0.2f) {
                    getGame().batch.setColor(new Color(
                            new Color(1, 0, 0, 1).mul(
                                    originalColor
                            )
                    ));
                    if (flashFill > 0.4f) {
                        flashFill = 0;
                    }
                }
                super.render(gameObject, delta);
                getGame().batch.setColor(originalColor);
                flashFill += delta;
            }
        });
    }

    @Override
    public CombatScreen.Fight getFight() {
        return attack.getFight();
    }

    @Override
    public Integer getDamage() {
        return attack.getDamage() * 10;
    }
}
