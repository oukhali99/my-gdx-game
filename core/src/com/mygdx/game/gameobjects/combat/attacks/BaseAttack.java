package com.mygdx.game.gameobjects.combat.attacks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.renderer.RendererDecorator;
import com.mygdx.game.components.updater.BaseUpdaterDecorator;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.utils.Logger;

public class BaseAttack extends BaseGameObject implements Attack {
    protected final Ability ability;
    protected final Character attacker;
    protected final Character target;
    protected final CombatScreen.Fight fight;
    private final Vector2 attackDirection;
    private float stateTime = 0;

    public BaseAttack(final Drop game, final Ability ability, final Character attacker, final Character target, final CombatScreen.Fight fight) {
        super(game);
        this.ability = ability;
        this.target = target;
        this.attacker = attacker;
        this.fight = fight;

        setPosition(attacker.getPosition());
        setScale(ability.getScale());

        attackDirection = target.getPosition().sub(attacker.getPosition()).nor();
        transform.setRotationFromVector(attackDirection);
    }

    private boolean isOutOfBounds() {
        return !new Rectangle(0, 0, Gdx.graphics.getWidth() * 2, Gdx.graphics.getHeight() * 2).contains(transform.getCenter());
    }

    @Override
    public CombatScreen.Fight getFight() {
        return fight;
    }

    public Integer getDamage() {
        return ability.getDamage();
    }

    @Override
    public Renderer getRenderer() {
        return new RendererDecorator(super.getRenderer()) {
            @Override
            public void render(GameObject gameObject, float delta) {
                super.render(gameObject, delta);

                Attack attack = (Attack) gameObject;
                float speed = 700;

                // Update the position of the fireball based on the elapsed time and speed
                float deltaX = speed * delta;
                Vector2 scaledAttackVector = new Vector2(attackDirection);
                scaledAttackVector.scl(deltaX);
                translate(scaledAttackVector);

                // Update the elapsed time
                stateTime += delta;

                // Check for out of bounds
                if (isOutOfBounds()) {
                    markForDestruction();
                    fight.applyDamage(attacker, target, attack.getDamage());
                }

                ability.draw(stateTime, transform);
            }
        };
    }

    @Override
    public Collider getCollider() {
        return new BaseCollider(game) {
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

        Attack attack = (Attack) gameObject;

        if (otherGameObject == target) {
            Logger.log("Attacked " + otherGameObject + " with " + ability.getName() + " for " + attack.getDamage() + " damage");
            markForDestruction();
            fight.applyDamage(attacker, target, attack.getDamage());
        }
    }
}
