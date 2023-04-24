package com.mygdx.game.gameobjects;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Texture;
import org.w3c.dom.Text;

public class CombatModeGameObject extends GameObject {
    private GameObject gameObject;

    public CombatModeGameObject(Drop game, GameObject gameObject) {
        super(game);
        this.gameObject = gameObject;

        Texture gameObjectTexture = (Texture) gameObject.getComponent(Texture.class);
        addComponent(new Texture(game, gameObjectTexture.getTexturePath()));

        setPosition(200, 200);
        setScale(64, 64);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //gameObject.render(delta);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        //gameObject.update(delta);
    }

    @Override
    public void postUpdate(float delta) {
        super.postUpdate(delta);
        //gameObject.postUpdate(delta);
    }

    @Override
    public Component getComponent(Class<? extends Component> componentClass) {
        return super.getComponent(componentClass);
    }

    @Override
    public void postPostUpdate(float delta) {
        super.postPostUpdate(delta);
        //gameObject.postPostUpdate(delta);
    }
}
