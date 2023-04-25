package com.mygdx.game.components.texture;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Transform;

public class MyTexture extends BaseComponent implements Component {
    private com.badlogic.gdx.graphics.Texture texture;
    private String texturePath;

    public MyTexture(Drop game, String texturePath) {
        super(game);
        this.texturePath = texturePath;
        this.texture = new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(texturePath));
    }

    public MyTexture(MyTexture myTexture) {
        super(myTexture.game);
        this.texture = myTexture.texture;
        this.texturePath = myTexture.texturePath;
    }

    @Override
    public void render(float delta) {
        draw(delta);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void postUpdate(float delta) {

    }

    protected void draw(float delta) {
        Transform transform = gameObject.getTransform();

        game.batch.draw(
                texture,
                transform.getPosition().x,
                transform.getPosition().y,
                transform.getScale().x,
                transform.getScale().y
        );
    }

    public void destroy() {
        texture.dispose();
    }

    @Override
    public void postPostUpdate(float delta) {

    }

    public String getTexturePath() {
        return texturePath;
    }
}
