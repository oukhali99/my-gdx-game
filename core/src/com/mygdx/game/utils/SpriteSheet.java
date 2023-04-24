package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class SpriteSheet {
    private String path;
    private int xCount;
    private int yCount;

    private Vector2 scale;
    private boolean flipTextureHorizontally;

    public SpriteSheet(String path, int xCount, int yCount, Vector2 scale, boolean flipTextureHorizontally) {
        this.path = path;
        this.xCount = xCount;
        this.yCount = yCount;
        this.scale = scale;
        this.flipTextureHorizontally = flipTextureHorizontally;
    }

    public TextureRegion[] getFrames() {
        Texture myTexture = new Texture(Gdx.files.internal(path));
        TextureRegion[] frames = new TextureRegion[xCount * yCount];
        int frameWidth = myTexture.getWidth() / xCount;
        int frameHeight = myTexture.getHeight() / yCount;
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                TextureRegion textureRegion = new TextureRegion(myTexture, i * frameWidth, j * frameHeight, frameWidth, frameHeight);
                textureRegion.flip(flipTextureHorizontally, false);
                frames[j * xCount + i] = textureRegion;
            }
        }
        return frames;
    }

    public Vector2 getScale() {
        return scale;
    }
}
