package com.mygdx.game.components.updater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.gameobjects.combat.characters.Character;

public class WASDMovement extends BaseUpdaterDecorator {
    private final float speed;

    public WASDMovement(Updater baseUpdater, float speed) {
        super(baseUpdater);
        this.speed = speed;
    }

    @Override
    public void update(Character character, float delta) {
        super.update(character, delta);
        Vector2 initialPosition = character.getPosition();

        if (character.getCurrentMoveCommand() == null || character.getCurrentMoveCommand().isCommandComplete(initialPosition)) {
            Vector2 destination = new Vector2(initialPosition);
            Vector2 directionUnit = new Vector2(0, 0);

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                directionUnit.add(Vector2.X.cpy().scl(-1));
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D) && directionUnit.isZero()) {
                directionUnit.add(Vector2.X.cpy().scl(1));
            }
            if (Gdx.input.isKeyPressed(Input.Keys.W) && directionUnit.isZero()) {
                directionUnit.add(Vector2.Y.cpy().scl(1));
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S) && directionUnit.isZero()) {
                directionUnit.add(Vector2.Y.cpy().scl(-1));
            }
            directionUnit.scl(16);
            destination.add(directionUnit);

            character.setCurrentMoveCommand(new MoveCommand(character, destination, speed));
        }
        else {
            character.getCurrentMoveCommand().continueExecuting(character, delta);
        }
    }

    @Override
    public void onCollision(GameObject gameObject, GameObject otherGameObject) {
        super.onCollision(gameObject, otherGameObject);

        Character character = (Character) gameObject;
        if (character.getCurrentMoveCommand() != null) {
            character.getCurrentMoveCommand().onCollision(gameObject);
            character.setCurrentMoveCommand(null);
        }
    }

    public class MoveCommand {
        private Vector2 destination;
        private float speed;
        private Vector2 lastPosition;

        public MoveCommand(GameObject gameObject, Vector2 destination, float speed) {
            this.destination = destination;
            this.speed = speed;
            this.lastPosition = gameObject.getPosition();
        }

        private boolean isCommandComplete(Vector2 position) {
            return position.epsilonEquals(destination, 2);
        }

        private void continueExecuting(GameObject gameObject, float delta) {
            Vector2 position = gameObject.getPosition();
            Vector2 moveDirection = destination.cpy().sub(position).nor();
            Vector2 moveVector = moveDirection.scl(delta * speed);

            lastPosition = new Vector2(position);

            gameObject.translate(moveVector);

            if (isCommandComplete(gameObject.getPosition())) {
                gameObject.setPosition(destination);
            }
        }

        public void onCollision(GameObject gameObject) {
            gameObject.setPosition(lastPosition);
        }
    }
}
