package com.mygdx.game.components.renderer;

import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;

public interface Renderer extends Component {
    public void render(GameObject gameObject, float delta);
}
