package com.mygdx.game.components.tilemap;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Drop;
import com.mygdx.game.components.BaseComponent;
import com.mygdx.game.components.Component;

public class Tilemap extends BaseComponent implements Component {
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
    public void render(float delta) {
        orthogonalTiledMapRenderer.setView(camera);
        orthogonalTiledMapRenderer.render();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void postUpdate(float delta) {

    }

    @Override
    public void destroy() {
        orthogonalTiledMapRenderer.dispose();
        map.dispose();
    }

    @Override
    public void postPostUpdate(float delta) {

    }

    public TiledMap getMap() {
        return map;
    }
}
