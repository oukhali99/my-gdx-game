package com.mygdx.game.components.texture;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Transform;

public class Texture extends Component {
    private com.badlogic.gdx.graphics.Texture texture;
    private String texturePath;

    public Texture(Drop game, String texturePath) {
        super(game);
        this.texturePath = texturePath;
        this.texture = new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(texturePath));
    }

    public Texture(Texture texture) {
        super(texture.game);
        this.texture = texture.texture;
        this.texturePath = texture.texturePath;
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
