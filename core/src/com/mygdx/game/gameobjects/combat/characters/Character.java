package com.mygdx.game.gameobjects.combat.characters;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.ThrowableAbilities;
import com.mygdx.game.components.collider.BaseColliderDecorator;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.renderer.IntegerDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.components.updater.NoUpdate;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public abstract class Character extends GameObject {
    private int health;
    private Updater updater;

    protected Character(Drop game) {
        super(game);

        this.health = 100;

        setUpdater(new NoUpdate(game, this));
        setCollider(new BaseColliderDecorator(getCollider()) {
            @Override
            protected void handleCollisionDecorator(GameObject gameObject) {
                getUpdater().onCollision(gameObject);
            }
        });
        setRenderer(new IntegerDependentTexture(new MyTexture(game, this, getTexturePath())) {
            @Override
            public int getInteger() {
                return getHealth();
            }
        });

        setScale(16, 16);
    }

    protected abstract String getTexturePath();

    @Override
    public void update(float delta) {
        super.update(delta);
        getUpdater().update(delta);
    }

    public Abilities getAbilities() {
        Abilities abilities = new ThrowableAbilities(game, this);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));
        return abilities;
    }

    public Integer getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;

        if (health <= 0) {
            health = 0;
            markForDestruction();
        }
    }

    public Updater getUpdater() {
        return updater;
    }

    public void setUpdater(Updater updater) {
        this.updater = updater;
    }
}
