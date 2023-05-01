package com.mygdx.game.components.renderer;

import com.mygdx.game.components.Component;

public interface Renderer extends Component {
    void render(float delta);

    void postRender(float delta);
}
