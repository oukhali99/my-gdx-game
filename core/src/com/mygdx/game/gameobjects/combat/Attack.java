package com.mygdx.game.gameobjects.combat;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Collider;
import com.mygdx.game.gameobjects.combat.combatmode.CombatModeGameObject;
import com.mygdx.game.gameplay.Ability;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.screens.CombatScreen;
import com.mygdx.game.utils.Logger;

public class Attack extends GameObject {
    private final Ability ability;
    private final CombatModeGameObject attacker;
    private final CombatModeGameObject target;
    private final CombatScreen.Fight fight;
    private final Vector2 attackDirection;

    public Attack(final Drop game, final Ability ability, final CombatModeGameObject attacker, final CombatModeGameObject target, final CombatScreen.Fight fight) {
        super(game);
        this.ability = ability;
        this.target = target;
        this.attacker = attacker;
        this.fight = fight;

        Collider collider = new Collider(game);
        collider.addOnCollisionRunnable(new Collider.CollisionRunnable() {
            @Override
            public void run(GameObject otherGameObject) {
                if (otherGameObject == target) {
                    Logger.log("Attacked " + otherGameObject + " with " + ability.getName() + " for " + ability.getDamage() + " damage");
                    markForDestruction();
                    fight.applyDamage(attacker, target, ability.getDamage());
                }
            }
        });
        addComponent(collider);

        setPosition(attacker.getPosition());
        setScale(ability.getScale());

        attackDirection = target.getPosition().sub(attacker.getPosition()).nor();
        transform.setRotationFromVector(attackDirection);
    }

    private float stateTime = 0;

    @Override
    public void render(float delta) {
        super.render(delta);

        ability.draw(stateTime, transform);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

        float speed = 1000;

        // Update the position of the fireball based on the elapsed time and speed
        float deltaX = speed * delta;
        Vector2 scaledAttackVector = new Vector2(attackDirection);
        scaledAttackVector.scl(deltaX);
        transform.translate(scaledAttackVector);

        // Update the elapsed time
        stateTime += delta;
    }

    public CombatScreen.Fight getFight() {
        return fight;
    }
}
