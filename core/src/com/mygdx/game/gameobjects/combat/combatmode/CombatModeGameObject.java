package com.mygdx.game.gameobjects.combat.combatmode;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.CustomCollider;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.Attack;
import com.mygdx.game.gameobjects.combat.combatactors.CombatActor;

public abstract class CombatModeGameObject extends GameObject {
    private CombatActor combatActor;

    public CombatModeGameObject(Drop game, CombatActor combatActor) {
        super(game);
        this.combatActor = combatActor;

        // Add the texture
        renderer = combatActor.getRenderer();

        // Add the collider
        GameObject thisGameObject = this;
        baseCollider = new CustomCollider(game) {
            @Override
            public CollisionRunnable getOnCollisionRunnable() {
                return new CollisionRunnable() {
                    @Override
                    public void run(GameObject otherGameObject) {
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

        // Scale up
        setScale(combatActor.getScale().cpy().scl(4));
    }

    public void performAttack(Attack attack) {
        children.add(attack);
        attack.getFight().endTurn();
    }

    public void takeDamage(int damage) {
        combatActor.takeDamage(damage);
    }

    public int getHealth() {
        return combatActor.getHealth();
    }

    public CombatActor getCombatActor() {
        return combatActor;
    }
}
