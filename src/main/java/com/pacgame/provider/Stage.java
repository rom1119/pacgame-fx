package com.pacgame.provider;

import com.pacgame.provider.ProvidedObject;
import com.pacgame.provider.stage.StageProxy;

public abstract class Stage extends ProvidedObject {

    private StageProxy proxy;

    public Stage(javafx.stage.Stage stage) {
        proxy = new StageProxy();
    }

    @Override
    protected StageProxy getProxy()
    {
        return proxy;
    }

}
