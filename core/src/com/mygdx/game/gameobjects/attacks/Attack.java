package com.mygdx.game.gameobjects.attacks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.ability.Ability;
import com.mygdx.game.components.collider.BaseCollider;
import com.mygdx.game.components.renderer.RendererBaseDecorator;
import com.mygdx.game.components.transform.Transform;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.characters.Character;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.utils.Logger;

public class Attack extends GameObject {
    protected final Character attacker;
    protected final Character target;
    protected final CombatScreen.Fight fight;
    private final Vector2 attackDirection;
    protected Ability ability;
    private float stateTime = 0;

    public Attack(final Drop game, final Ability ability, final Character attacker, final Character target, final CombatScreen.Fight fight) {
        super(game);
        this.ability = ability;
        this.target = target;
        this.attacker = attacker;
        this.fight = fight;

        setPosition(attacker.getPosition().add(new Vector2(0, ability.getScale().y / 2)));
        setScale(ability.getScale());

        attackDirection = target.getPosition().sub(attacker.getPosition()).nor();
        transform.setRotationFromVector(attackDirection);

        setRenderer(new RendererBaseDecorator(getRenderer()) {
            @Override
            public void render(float delta) {
                super.render(delta);

                float speed = 300;

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
                    fight.applyDamage(attacker, target, getDamage());
                }

                ability.draw(stateTime, transform);
            }
        });
        setCollider(new BaseCollider(game, this) {
            @Override
            public void handleCollision(GameObject otherGameObject) {
                if (otherGameObject == target) {
                    Logger.log("Attacked " + otherGameObject + " with " + ability.getName() + " for " + getDamage() + " damage");
                    markForDestruction();
                    fight.applyDamage(attacker, target, getDamage());
                }
            }

            @Override
            public Rectangle getArea() {
                Transform transform = gameObject.getTransform();
                Rectangle rectangle = new Rectangle();
                rectangle.x = transform.getPosition().x;
                rectangle.y = transform.getPosition().y;
                rectangle.width = transform.getScale().x;
                rectangle.height = transform.getScale().y;
                return rectangle;
            }
        });
    }

    private boolean isOutOfBounds() {
        return !new Rectangle(0, 0, Gdx.graphics.getWidth() * 2, Gdx.graphics.getHeight() * 2).contains(transform.getCenter());
    }

    public CombatScreen.Fight getFight() {
        return fight;
    }

    public Integer getDamage() {
        return ability.getDamage();
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
