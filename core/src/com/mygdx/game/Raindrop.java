package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;

public class Raindrop extends GameObject {

    public Raindrop(final Drop game) {
        super(game);
        //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
    }

    @Override
    public void update(float delta) {
        transform.translate(0, -200 * Gdx.graphics.getDeltaTime());

        /*
        if (transform.getPosition().y + 64 < 0)
            iter.remove();
        if (raindrop.overlaps(bucket)) {
            dropsGathered++;
            dropSound.play();
            iter.remove();
        }
         */
    }

    @Override
    protected String getTexturePath() {
        return "droplet.png";
    }
}
