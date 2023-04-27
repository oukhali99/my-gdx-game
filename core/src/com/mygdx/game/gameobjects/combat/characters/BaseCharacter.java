package com.mygdx.game.gameobjects.combat.characters;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.NoAbilities;
import com.mygdx.game.components.abilities.ThrowableAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.HealthDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public abstract class BaseCharacter extends BaseGameObject implements Character {
    protected BaseCharacter(Drop game) {
        super(game);

        setScale(16, 16);
        renderer = new HealthDependentTexture(new MyTexture(game, getTexturePath()));

        /*
         */

        baseCollider = new BaseCollider(game) {
            @Override
            public Rectangle getArea(GameObject gameObject) {
                Transform transform = gameObject.getTransform();
                Rectangle rectangle = new Rectangle();
                rectangle.x = transform.getPosition().x;
                rectangle.y = transform.getPosition().y;
                rectangle.width = transform.getScale().x;
                rectangle.height = transform.getScale().y;
                return rectangle;
            }
        };
    }

    @Override
    public Abilities getAbilities() {
        Abilities abilities = new ThrowableAbilities(game);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));
        return abilities;
    }
}
