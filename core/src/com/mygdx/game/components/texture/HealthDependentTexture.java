package com.mygdx.game.components.texture;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public abstract class HealthDependentTexture extends Component {
    private MyTexture baseMyTexture;

    public HealthDependentTexture(Drop game, MyTexture baseMyTexture) {
        super(game);
        this.baseMyTexture = baseMyTexture;
    }

    public HealthDependentTexture(HealthDependentTexture healthDependentTexture) {
        super(healthDependentTexture.game);
        baseMyTexture = new MyTexture(healthDependentTexture.baseMyTexture);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        float healthFraction = (float) getHealth() / 100;

        Color color = game.batch.getColor();
        game.batch.setColor(1, healthFraction, healthFraction, 1);
        baseMyTexture.render(delta);
        game.batch.setColor(color);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        baseMyTexture.update(delta);
    }

    @Override
    public void postUpdate(float delta) {
        super.postUpdate(delta);
        baseMyTexture.postUpdate(delta);
    }

    @Override
    public void attachToGameObject(GameObject gameObject) {
        super.attachToGameObject(gameObject);
        baseMyTexture.attachToGameObject(gameObject);
    }

    @Override
    public void postPostUpdate(float delta) {
        super.postPostUpdate(delta);
        baseMyTexture.postPostUpdate(delta);
    }

    public abstract int getHealth();
}
