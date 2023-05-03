package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Drop;
import com.mygdx.game.components.abilities.Abilities;
import com.mygdx.game.components.abilities.NoAbilities;
import com.mygdx.game.components.collider.Collider;
import com.mygdx.game.components.collider.NoCollisions;
import com.mygdx.game.components.movement.Movement;
import com.mygdx.game.components.movement.MovementNone;
import com.mygdx.game.components.renderer.NoTexture;
import com.mygdx.game.components.renderer.Renderer;
import com.mygdx.game.components.transform.BasicTransform;
import com.mygdx.game.components.transform.Transform;

import java.util.LinkedList;
import java.util.List;

public abstract class GameObject {
    protected final Drop game;
    private final List<GameObject> collisionObjectsThisFrame;
    protected Transform transform;
    protected List<GameObject> children;
    private boolean markedForDestruction;
    private Renderer renderer;
    private Movement movement;
    private Abilities abilities;
    private Collider collider;

    protected GameObject(final Drop game) {
        this.game = game;
        this.markedForDestruction = false;
        this.children = new LinkedList<>();
        this.collisionObjectsThisFrame = new LinkedList<>();

        setRenderer(new NoTexture(game, this));
        setCollider(new NoCollisions(game, this));
        setTransform(new BasicTransform(game, this));
        setAbilities(new NoAbilities(game, this));
        setMovement(new MovementNone(game, this, 128));
    }

    public GameObject(GameObject gameObject) {
        this.game = gameObject.game;
        this.collisionObjectsThisFrame = gameObject.collisionObjectsThisFrame;
        this.markedForDestruction = gameObject.markedForDestruction;
        this.children = gameObject.children;

        this.renderer = gameObject.renderer;
        this.collider = gameObject.collider;
        this.transform = gameObject.transform;
        this.abilities = gameObject.abilities;
        this.movement = gameObject.movement;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void setPosition(float x, float y) {
        transform.setPosition(new Vector2(x, y));
    }

    public Vector2 getPosition() {
        return transform.getPosition();
    }

    public void setPosition(Vector2 position) {
        transform.setPosition(new Vector2(position));
    }

    public void setScale(float x, float y) {
        transform.setScale(new Vector2(x, y));
    }

    public Vector2 getScale() {
        return transform.getScale();
    }

    public void setScale(Vector2 scale) {
        transform.setScale(new Vector2(scale));
    }

    public Collider getCollider() {
        return collider;
    }

    public void setCollider(Collider collider) {
        this.collider = collider;
    }

    public Transform getTransform() {
        return transform;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public boolean isMarkedForDestruction() {
        return markedForDestruction;
    }

    public void markForDestruction() {
        markedForDestruction = true;
    }

    public void destroy() {
        for (GameObject child : children) {
            child.destroy();
        }
    }

    public void preenDestroyedChildren() {
        List<GameObject> enabledGameObjects = new LinkedList<>();
        for (GameObject gameObject : children) {
            if (gameObject.isMarkedForDestruction()) {
                gameObject.destroy();
            } else {
                enabledGameObjects.add(gameObject);
            }
        }
        children = enabledGameObjects;
    }

    public List<GameObject> getChildren() {
        return new LinkedList<>(children);
    }

    public void addChild(GameObject child) {
        children.add(child);
    }

    public Drop getGame() {
        return game;
    }

    public void translate(Vector2 amount) {
        transform.translate(amount);
    }

    public void render(float delta) {
        getRenderer().setGameObject(this);
        getRenderer().render(delta);

        for (GameObject child : getChildren()) {
            child.getRenderer().setGameObject(child);
            child.getRenderer().render(delta);
        }
    }

    public void update(float delta) {
    }

    public void postUpdate(float delta, List<GameObject> gameObjects) {
        getCollider().setGameObject(this);
        getCollider().lookForCollisions(delta, gameObjects);

        for (GameObject child : getChildren()) {
            child.getCollider().setGameObject(child);
            child.getCollider().lookForCollisions(delta, gameObjects);
        }
    }

    public void postPostUpdate(float delta) {
        getCollider().setGameObject(this);
        for (GameObject otherGameObject : getCollider().getCollisionObjectsThisFrame()) {
            getCollider().handleCollision(otherGameObject);
        }

        for (GameObject child : getChildren()) {
            child.getCollider().setGameObject(child);
            for (GameObject otherGameObject : child.getCollider().getCollisionObjectsThisFrame()) {
                child.getCollider().handleCollision(otherGameObject);
            }
        }
    }

    @Override
    public GameObject clone() {
        return new GameObject(this) {
        };
    }

    public void postRender(float delta) {
        getRenderer().setGameObject(this);
        getRenderer().postRender(delta);

        for (GameObject child : getChildren()) {
            child.getRenderer().setGameObject(child);
            child.getRenderer().postRender(delta);
        }
    }

    public Vector2 getScreenSpacePosition() {
        Vector3 gamePosition = new Vector3(getPosition().cpy(), 0);
        Camera camera = game.getScreen().getCamera();

        camera.project(gamePosition);

        return new Vector2(gamePosition.x, gamePosition.y);
    }

    public Vector2 getScreenSpaceScale() {
        Vector2 screenSpaceScale = getScale().cpy();
        Camera camera = game.getScreen().getCamera();

        // Calculate the ratio between the game world size and the screen size
        float worldUnitsPerScreenPixel = camera.viewportWidth / camera.viewportHeight;
        float screenPixelsPerWorldUnit = camera.viewportHeight / Gdx.graphics.getHeight();

        // Apply the ratio to the scale
        screenSpaceScale.x *= screenPixelsPerWorldUnit * worldUnitsPerScreenPixel;
        screenSpaceScale.y *= screenPixelsPerWorldUnit;

        return screenSpaceScale;
    }

    public void renderUi(float delta) {
    }

    public void resize(int width, int height) {
        getRenderer().resize(width, height);

        for (GameObject child : children) {
            child.resize(width, height);
        }
    }
}
