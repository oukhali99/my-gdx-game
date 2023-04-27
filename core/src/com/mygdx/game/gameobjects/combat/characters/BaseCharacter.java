package com.mygdx.game.gameobjects.combat.characters;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.ThrowableAbilities;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.IntegerDependentTexture;
import com.mygdx.game.components.renderer.MyTexture;
import com.mygdx.game.components.updater.NoUpdate;
import com.mygdx.game.components.updater.Updater;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameplay.Fireball;
import com.mygdx.game.gameplay.Snowball;

public abstract class BaseCharacter extends BaseGameObject implements Character {
    private int health;
    private WASDMovement.MoveCommand currentMoveCommand;

    protected BaseCharacter(Drop game) {
        super(game);

        this.health = 100;

        setScale(16, 16);
        renderer = new IntegerDependentTexture(new MyTexture(game, getTexturePath())) {
            @Override
            public int getInteger(GameObject gameObject) {
                Character character = (Character) gameObject;
                return character.getHealth();
            }
        };

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
    public void onCollision(GameObject gameObject, GameObject otherGameObject) {
        super.onCollision(gameObject, otherGameObject);
        getUpdater().onCollision(gameObject, otherGameObject);
    }

    @Override
    public void update(GameObject gameObject, float delta) {
        super.update(gameObject, delta);

        Character character = (Character) gameObject;
        character.getUpdater().update(character, delta);
    }

    @Override
    public Abilities getAbilities() {
        Abilities abilities = new ThrowableAbilities(game);
        abilities.addAbility(new Fireball(game));
        abilities.addAbility(new Snowball(game));
        return abilities;
    }

    @Override
    public Integer getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;

        if (health <= 0) {
            health = 0;
            markForDestruction();
        }
    }

    @Override
    public Updater getUpdater() {
        return new NoUpdate(game);
    }

    @Override
    public WASDMovement.MoveCommand getCurrentMoveCommand() {
        return currentMoveCommand;
    }

    @Override
    public void setCurrentMoveCommand(WASDMovement.MoveCommand moveCommand) {
        currentMoveCommand = moveCommand;
    }
}
