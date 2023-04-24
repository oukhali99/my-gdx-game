package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Drop;

public class Texture extends Component {
    private com.badlogic.gdx.graphics.Texture texture;
    private String texturePath;

    public Texture(Drop game, String texturePath) {
        super(game);
        this.texturePath = texturePath;
        this.texture = new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(texturePath));
    }

    @Override
    public void render(float delta) {
        super.render(delta);

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

    public String getTexturePath() {
        return texturePath;
    }
}
