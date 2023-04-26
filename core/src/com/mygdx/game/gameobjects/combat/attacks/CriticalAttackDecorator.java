package com.mygdx.game.gameobjects.combat.attacks;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.renderer.RendererDecorator;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.GameObjectDecorator;
import com.mygdx.game.gameobjects.combat.attacks.Attack;
import com.mygdx.game.screens.CombatScreen;

public class CriticalAttackDecorator extends GameObjectDecorator implements Attack {
    private Attack attack;

    public CriticalAttackDecorator(Attack attack) {
        super(attack);
        this.attack = attack;
    }

    @Override
    public CombatScreen.Fight getFight() {
        return attack.getFight();
    }

    @Override
    public Integer getDamage() {
        return attack.getDamage() * 10;
    }

    @Override
    public Renderer getRenderer() {
        return new RendererDecorator(super.getRenderer()) {
            @Override
            public void render(GameObject gameObject, float delta) {
                Color originalColor = new Color(game.batch.getColor());
                game.batch.setColor(new Color(
                        new Color(0.5f, 1, 0.5f, 1).mul(
                                originalColor
                        )
                ));
                super.render(gameObject, delta);
                game.batch.setColor(originalColor);
            }
        };
    }
}
