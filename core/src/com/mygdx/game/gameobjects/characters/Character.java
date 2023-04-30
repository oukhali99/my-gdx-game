package com.mygdx.game.gameobjects.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.ThrowableAbilities;
import com.mygdx.game.components.abilities.ability.Fireball;
import com.mygdx.game.components.abilities.ability.Snowball;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.components.renderer.IntegerDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Character extends GameObject {

    protected Character(Drop game) {
        super(game);

        setCollider(new RectangleCollider(game, this));

        setRenderer(new IntegerDependentTexture(new MyTexture(game, this, getTexturePath())) {
            @Override
            public int getInteger() {
                return getHealth();
            }
        });

        Abilities abilities = new ThrowableAbilities(game, this);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));
        setAbilities(abilities);

        setScale(16, 16);
    }

    public Character(Character character) {
        super(character);
    }

    public abstract String getTexturePath();

    @Override
    public void update(float delta) {
        super.update(delta);

        getMovement().setGameObject(this);
        getMovement().update(delta);
    }

    public Integer getHealth() {
        return getAbilities().getHealth();
    }

    public void takeDamage(int damage) {
        getAbilities().takeDamage(damage);
    }

    @Override
    public Character clone() {
        final Character finalCharacter = this;
        return new Character(finalCharacter) {
            @Override
            public String getTexturePath() {
                return finalCharacter.getTexturePath();
            }
        };
    }
}
