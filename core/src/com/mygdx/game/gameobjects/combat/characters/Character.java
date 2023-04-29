package com.mygdx.game.gameobjects.combat.characters;

import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.ThrowableAbilities;
import com.mygdx.game.components.collider.ColliderBaseDecorator;
import com.mygdx.game.components.collider.RectangleCollider;
import com.mygdx.game.components.renderer.IntegerDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.components.updater.NoUpdate;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public abstract class Character extends GameObject {
    private Updater updater;
    private Abilities abilities;

    protected Character(Drop game) {
        super(game);

        setUpdater(new NoUpdate(game, this));

        setCollider(new ColliderBaseDecorator(new RectangleCollider(game, this)) {
            @Override
            public void handleCollision(GameObject otherGameObject) {
                super.handleCollision(otherGameObject);
                getUpdater().onCollision(otherGameObject);
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
        this.updater = character.updater;
        this.abilities = character.abilities;
    }

    public abstract String getTexturePath();

    @Override
    public void update(float delta) {
        super.update(delta);

        getUpdater().setGameObject(this);
        getUpdater().update(delta);
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

    public Updater getUpdater() {
        return updater;
    }

    public void setUpdater(Updater updater) {
        this.updater = updater;
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
