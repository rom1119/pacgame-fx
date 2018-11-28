package com.pacgame.game.adapter.factory;

import com.pacgame.game.ILayer;
import com.pacgame.game.IScene;
import com.pacgame.game.ISceneFactory;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.adapter.SceneAdapter;
import com.pacgame.stage.SceneFactory;

public class SceneFactoryAdapter implements ISceneFactory {

    private SceneFactory sceneFactory;

    public SceneFactoryAdapter(SceneFactory sceneFactory) {
        this.sceneFactory = sceneFactory;
    }

    @Override
    public IScene createScene(ILayer layer, int width, int height) {
        com.pacgame.stage.IScene scene = sceneFactory.createScene(((LayerAdapter) layer).getProvidedObject(), width, height);
        return new SceneAdapter(scene);
    }
}
