package com.mygdx.game.gameobjects.combat.combatmode;

import com.mygdx.game.Drop;
import com.mygdx.game.components.Abilities;
import com.mygdx.game.components.Component;
import com.mygdx.game.components.Texture;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;

public abstract class CombatModeGameObject extends GameObject {
    private final CombatActor combatActor;

    public CombatModeGameObject(Drop game, CombatActor combatActor) {
        super(game);
        this.combatActor = combatActor;

        // Add the texture
        Texture gameObjectTexture = (Texture) combatActor.getComponent(Texture.class);
        addComponent(new Texture(game, gameObjectTexture.getTexturePath()));

        // Copy the abilities
        Abilities baseAbilities = (Abilities) combatActor.getComponent(Abilities.class);
        addComponent(new Abilities(baseAbilities));

        // Scale up
        setScale(combatActor.getScale().cpy().scl(4));
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
