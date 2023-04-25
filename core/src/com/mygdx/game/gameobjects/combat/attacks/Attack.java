package com.mygdx.game.gameobjects.combat.attacks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.CustomCollider;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.gameobjects.BaseGameObject;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.utils.Logger;

public class Attack extends BaseGameObject {
    protected final Ability ability;
    protected final BaseGameObject attacker;
    protected final BaseGameObject target;
    protected final CombatScreen.Fight fight;
    private final Vector2 attackDirection;

    public Attack(final Drop game, final Ability ability, final BaseGameObject attacker, final BaseGameObject target, final CombatScreen.Fight fight) {
        super(game);
        this.ability = ability;
        this.target = target;
        this.attacker = attacker;
        this.fight = fight;

        final BaseGameObject thisBaseGameObject = this;
        baseCollider = new CustomCollider(game) {
            @Override
            public CollisionRunnable getOnCollisionRunnable() {
                return new CollisionRunnable() {
                    @Override
                    public void run(BaseGameObject otherBaseGameObject) {
                        if (otherBaseGameObject == target) {
                            Logger.log("Attacked " + otherBaseGameObject + " with " + ability.getName() + " for " + ability.getDamage() + " damage");
                            resolveAttack(getDamage());
                        }
                    }
                };
            }

            @Override
            public Rectangle getArea() {
                Transform transform = getTransform();
                Rectangle rectangle = new Rectangle();
                rectangle.x = transform.getPosition().x;
                rectangle.y = transform.getPosition().y;
                rectangle.width = transform.getScale().x;
                rectangle.height = transform.getScale().y;
                return rectangle;
            }
        };

        setPosition(attacker.getPosition());
        setScale(ability.getScale());

        attackDirection = target.getPosition().sub(attacker.getPosition()).nor();
        transform.setRotationFromVector(attackDirection);
    }

    private float stateTime = 0;

    @Override
    public void render(float delta) {
        super.render(delta);
        draw(delta);
    }

    protected void draw(float delta) {
        ability.draw(stateTime, transform);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

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
            resolveAttack(0);
        }
    }

    private void resolveAttack(int damage) {
        markForDestruction();
        fight.applyDamage(attacker, target, damage);
    }

    private boolean isOutOfBounds() {
        return !new Rectangle(0, 0, Gdx.graphics.getWidth() * 2, Gdx.graphics.getHeight() * 2).contains(transform.getCenter());
    }

    protected void translate(Vector2 scaledAttackVector) {
        transform.translate(scaledAttackVector);
    }

    public CombatScreen.Fight getFight() {
        return fight;
    }

    protected int getDamage() {
        return ability.getDamage();
    }
}
