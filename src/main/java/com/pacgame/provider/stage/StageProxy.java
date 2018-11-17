package com.pacgame.provider.stage;

import com.pacgame.provider.Proxy;
import com.pacgame.provider.scene.SceneProxy;
import javafx.stage.Stage;

public class StageProxy extends Proxy {
    protected Stage proxyObject;

    public StageProxy(Stage proxyObject) {
        this.proxyObject = proxyObject;
    }

    public void setScene(SceneProxy scene)
    {
        proxyObject.setScene(scene.getProxyObject());
    }
}
