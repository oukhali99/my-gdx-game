package com.mygdx.game.components.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.gameobjects.GameObject;

public class MyTexture extends BaseRenderer {
    private com.badlogic.gdx.graphics.Texture texture;
    private String texturePath;

    public MyTexture(Drop game, GameObject gameObject, String texturePath) {
        super(game, gameObject);
        this.texturePath = texturePath;
        this.texture = new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(texturePath));
    }

    public MyTexture(MyTexture baseMyTexture) {
        super(baseMyTexture.game, baseMyTexture.gameObject);
        this.texture = baseMyTexture.texture;
        this.texturePath = baseMyTexture.texturePath;
    }

    @Override
    public void render(float delta) {
        draw(delta);
    }

    public void draw(float delta) {
        Transform transform = gameObject.getTransform();

        game.batch.draw(
                texture,
                transform.getPosition().x,
                transform.getPosition().y,
                transform.getScale().x,
                transform.getScale().y
        );
    }

    @Override
    public void destroy() {
        texture.dispose();
    }

    public String getTexturePath() {
        return texturePath;
    }
}
