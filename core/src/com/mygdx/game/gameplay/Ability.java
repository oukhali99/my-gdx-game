package com.mygdx.game.gameplay;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.utils.Logger;

public abstract class Ability {
    private final String name;
    private final int damage;
    private final Animation animation;

    public Ability(String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.animation = initializeAnimation();
    }

    protected abstract Animation initializeAnimation();

    public String getName() {
        return name;
    }

    public void display() {
        Logger.log("Ability " + name + " for " + damage + " damage");
    }

    public int getDamage() {
        return damage;
    }

    public Animation getAnimation() {
        return animation;
    }
}
