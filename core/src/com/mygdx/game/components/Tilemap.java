package com.mygdx.game.components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Drop;

public class Tilemap extends Component {
    private TiledMap map;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private  OrthographicCamera camera;

    public Tilemap(Drop game, OrthographicCamera camera) {
        super(game);
        this.camera = camera;
    }

    @Override
    public void initialize() {
        super.initialize();

        // Load the tilemap
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("map/map.tmx");
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        orthogonalTiledMapRenderer.setView(camera);
        orthogonalTiledMapRenderer.render();
    }

    @Override
    public void destroy() {
        super.destroy();
        orthogonalTiledMapRenderer.dispose();
        map.dispose();
    }
}
