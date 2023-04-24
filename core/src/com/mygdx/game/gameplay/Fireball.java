package com.mygdx.game.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Fireball extends Ability {
    public Fireball() {
        super("Fireball", 10);
    }

    @Override
    protected Animation initializeAnimation() {
        Texture myTexture = new Texture(Gdx.files.internal("droplet.png"));
        TextureRegion[] frames = new TextureRegion[4];
        int frameWidth = myTexture.getWidth() / 4;
        int frameHeight = myTexture.getHeight();
        for (int i = 0; i < 4; i++) {
            frames[i] = new TextureRegion(myTexture, i * frameWidth, 0, frameWidth, frameHeight);
        }
        return new Animation(0.1f, frames);
    }
}
