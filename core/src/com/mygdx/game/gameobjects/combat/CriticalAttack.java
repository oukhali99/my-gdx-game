package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;

public class CriticalAttack extends Attack {
    private Attack baseAttack;
    private float flashTimer;
    private Color originalColor;

    public CriticalAttack(Drop game, Attack baseAttack) {
        super(game, baseAttack.ability, baseAttack.attacker, baseAttack.target, baseAttack.fight);
        this.baseAttack = baseAttack;
        this.flashTimer = 0;
        this.originalColor = new Color(game.batch.getColor());
    }

    @Override
    protected void draw(float delta) {
        if (flashTimer > 0.1f) {
            game.batch.setColor(Color.GREEN);

            if (flashTimer > 0.2f) {
                flashTimer = 0;
            }
        }
        super.draw(delta);
        game.batch.setColor(originalColor);

        flashTimer += delta;
    }

    @Override
    protected int getDamage() {
        return super.getDamage() * 2;
    }
}
