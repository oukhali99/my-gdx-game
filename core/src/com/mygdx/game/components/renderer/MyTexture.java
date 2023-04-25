package com.mygdx.game.components.renderer;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;

public class MyTexture extends Renderer {
    private com.badlogic.gdx.graphics.Texture texture;
    private String texturePath;

    public MyTexture(Drop game, String texturePath) {
        super(game);
        this.texturePath = texturePath;
        this.texture = new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(texturePath));
    }

    public MyTexture(MyTexture baseMyTexture) {
        super(baseMyTexture.game);
        this.texture = baseMyTexture.texture;
        this.texturePath = baseMyTexture.texturePath;
    }

    @Override
    public void render(GameObject baseGameObject, float delta) {
        draw(baseGameObject, delta);
    }

    public void draw(GameObject baseGameObject, float delta) {
        Transform transform = baseGameObject.getTransform();

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
