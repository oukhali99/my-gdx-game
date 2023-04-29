package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.ThrowableAbilities;
import com.mygdx.game.components.abilities.ability.Fireball;
import com.mygdx.game.components.abilities.ability.Snowball;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.components.renderer.IntegerDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.components.movement.MovementNone;
import com.mygdx.game.components.movement.Movement;
import com.mygdx.game.gameobjects.GameObject;

public abstract class Character extends GameObject {
    private Movement movement;
    private Abilities abilities;

    protected Character(Drop game) {
        super(game);

        setMovement(new MovementNone(game, this, 128));

        setCollider(new ColliderBaseDecorator(new RectangleCollider(game, this)) {
            @Override
            public void handleCollision(GameObject otherGameObject) {
                super.handleCollision(otherGameObject);
                getMovement().onCollision(otherGameObject);
            }
        });

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
        this.movement = character.movement;
        this.abilities = character.abilities;
    }

    public abstract String getTexturePath();

    @Override
    public void update(float delta) {
        super.update(delta);

        getMovement().setGameObject(this);
        getMovement().update(delta);
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Integer getHealth() {
        return getAbilities().getHealth();
    }

    public void takeDamage(int damage) {
        getAbilities().takeDamage(damage);
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement updater) {
        this.movement = updater;
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
