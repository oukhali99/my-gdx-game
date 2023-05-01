package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class RendererHealthBarDecorator extends RendererBaseDecorator {
    private ShapeRenderer shapeRenderer;

    public RendererHealthBarDecorator(Renderer baseRenderer) {
        super(baseRenderer);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void postRender(float delta) {
        super.postRender(delta);

        // get the health percentage of the game object
        float healthPercentage = (float) getHealth() / 100;

        Vector2 offset = getGameObject().getScale().cpy();
        offset.x = 0;
        Vector2 barPosition = getGameObject().getScreenSpacePosition(offset);

        // set the color and size of the health bar
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(
                barPosition.x,
                barPosition.y,
                healthPercentage * 100,
                10);
        shapeRenderer.end();
    }


    private int getHealth() {
        return getGameObject().getAbilities().getHealth();
    }

    @Override
    public void destroy() {
        super.destroy();
        shapeRenderer.dispose();
    }
}
