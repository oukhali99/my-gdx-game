package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;

public class Tilemap extends Renderer {
    private TiledMap map;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private  OrthographicCamera camera;

    public Tilemap(Drop game, OrthographicCamera camera, String tilemapPath) {
        super(game);
        this.camera = camera;

        // Load the tilemap
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load(tilemapPath);
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void render(GameObject gameObject, float delta) {
        orthogonalTiledMapRenderer.setView(camera);
        orthogonalTiledMapRenderer.render();
    }

    @Override
    public void destroy() {
        orthogonalTiledMapRenderer.dispose();
        map.dispose();
    }

    public TiledMap getMap() {
        return map;
    }
}
