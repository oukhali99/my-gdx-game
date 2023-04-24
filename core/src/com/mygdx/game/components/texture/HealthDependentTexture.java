package com.mygdx.game.components.texture;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public abstract class HealthDependentTexture extends Component {
    private Texture baseTexture;

    public HealthDependentTexture(Drop game, Texture baseTexture) {
        super(game);
        this.baseTexture = baseTexture;
    }

    public HealthDependentTexture(HealthDependentTexture healthDependentTexture) {
        super(healthDependentTexture.game);
        baseTexture = new Texture(healthDependentTexture.baseTexture);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        float healthFraction = (float) getHealth() / 100;

        Color color = game.batch.getColor();
        game.batch.setColor(1, healthFraction, healthFraction, 1);
        baseTexture.render(delta);
        game.batch.setColor(color);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        baseTexture.update(delta);
    }

    @Override
    public void postUpdate(float delta) {
        super.postUpdate(delta);
        baseTexture.postUpdate(delta);
    }

    @Override
    public void attachToGameObject(GameObject gameObject) {
        super.attachToGameObject(gameObject);
        baseTexture.attachToGameObject(gameObject);
    }

    @Override
    public void postPostUpdate() {
        super.postPostUpdate();
        baseTexture.postPostUpdate();
    }

    public abstract int getHealth();
}
