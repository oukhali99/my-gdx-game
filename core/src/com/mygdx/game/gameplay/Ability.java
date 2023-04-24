package com.mygdx.game.gameplay;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.utils.Logger;
import com.mygdx.game.utils.SpriteSheet;

public abstract class Ability {
    private final Drop game;
    private final String name;
    private final int damage;
    private final Animation animation;

    public Ability(Drop game, String name, int damage) {
        this.game = game;
        this.name = name;
        this.damage = damage;
        this.animation = new Animation(0.1f, getSpriteSheet().getFrames());
    }

    protected abstract SpriteSheet getSpriteSheet();

    public Vector2 getScale() {
        return getSpriteSheet().getScale();
    }

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

    public void draw(float stateTime, Vector2 position) {
        // Get the current frame of the animation based on the elapsed time
        TextureRegion currentFrame = (TextureRegion) getAnimation().getKeyFrame(stateTime, true);

        // Draw the current frame at the current position of the fireball
        game.batch.draw(currentFrame, position.x, position.y, getSpriteSheet().getScale().x, getSpriteSheet().getScale().y);
    }
}
