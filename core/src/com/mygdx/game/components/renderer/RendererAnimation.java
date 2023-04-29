package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.utils.SpriteSheet;

public class RendererAnimation extends RendererBaseDecorator {
    private final Animation animation;
    private float stateTime;
    private SpriteSheet spriteSheet;

    public RendererAnimation(Renderer baseRenderer) {
        super(baseRenderer);

        this.spriteSheet = new SpriteSheet("chaz-spritesheet.png", 8, 1, new Vector2(16, 16), false);
        this.animation = new Animation(0.2f, spriteSheet.getFrames());
        this.stateTime = 0;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        // Get the current frame of the animation based on the elapsed time
        TextureRegion currentFrame = (TextureRegion) animation.getKeyFrame(stateTime, true);

        // Draw the current frame at the current position of the fireball
        Transform transform = getGameObject().getTransform();
        getGame().batch.draw(
                currentFrame,
                transform.getPosition().x,
                transform.getPosition().y,
                transform.getScale().x / 2f,
                transform.getScale().y / 2f,
                spriteSheet.getScale().x,
                spriteSheet.getScale().y,
                1,
                1,
                transform.getRotation()
        );

        stateTime += delta;
    }
}
