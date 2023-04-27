package com.mygdx.game.components.updater;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Component;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public interface Updater extends Component  {
    public void update(Character character, float delta);

    public void onCollision(GameObject gameObject, GameObject otherGameObject);
}
