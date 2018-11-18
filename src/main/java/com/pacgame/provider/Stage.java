package com.pacgame.provider;

import com.pacgame.provider.scene.SceneProvidedObject;
import com.pacgame.provider.stage.IStage;
import com.pacgame.provider.stage.StageProxy;

public abstract class Stage extends ProvidedObject implements IStage {

    private StageProxy proxy;

    public Stage() {
        proxy = new StageProxy();
    }

    @Override
    protected StageProxy getProxy()
    {
        return proxy;
    }

    public void setScene(SceneProvidedObject scene)
    {
        proxy.setScene(scene.getProxy());
    }

    public void setResizable(boolean b) {
        proxy.setResizable(b);
    }

    public void setTitle(String s) {
        proxy.setTitle(s);
    }

    public void show() {
        proxy.show();
    }
}
