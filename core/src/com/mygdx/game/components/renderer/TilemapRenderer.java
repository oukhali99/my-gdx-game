package com.mygdx.game.components.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.Drop;
import com.mygdx.game.gameobjects.GameObject;
import com.mygdx.game.utils.MyTiledMap;

public class TilemapRenderer extends Renderer {
    private MyTiledMap map;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private  OrthographicCamera camera;

    public TilemapRenderer(Drop game, GameObject gameObject, OrthographicCamera camera, MyTiledMap map) {
        super(game, gameObject);
        this.camera = camera;
        this.map = map;

        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(map.getTiledMap());
    }

    @Override
    public void render(float delta) {
        orthogonalTiledMapRenderer.setView(camera);
        orthogonalTiledMapRenderer.render();
    }

    @Override
    public void destroy() {
        orthogonalTiledMapRenderer.dispose();
    }
}
