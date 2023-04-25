package com.mygdx.game.gameobjects.combat.combatactors;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Drop;
import com.mygdx.game.components.Transform;
import com.mygdx.game.components.collider.CustomCollider;
import com.mygdx.game.components.updater.NoUpdate;
import com.mygdx.game.components.updater.WASDMovement;
import com.mygdx.game.gameobjects.GameObject;

public class Player extends CombatActor {
    public Player(Drop game) {
        super(game);

        setPosition(16*20, 16*20);
        setScale(16, 16);

        baseUpdater = new WASDMovement(new NoUpdate(game), 8);

        final GameObject thisGameObject = this;
        baseCollider = new CustomCollider(game) {
            @Override
            public CollisionRunnable getOnCollisionRunnable() {
                return new CollisionRunnable() {
                    @Override
                    public void run(GameObject otherGameObject) {
                        baseUpdater.onCollision(thisGameObject, otherGameObject);
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
    }

    @Override
    protected String getTexturePath() {
        return "bucket.png";
    }
}
