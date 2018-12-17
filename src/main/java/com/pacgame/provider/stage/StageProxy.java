package com.pacgame.provider.stage;

import com.pacgame.provider.Proxy;
import com.pacgame.provider.scene.SceneProxy;
import javafx.stage.Stage;

public class StageProxy extends Proxy implements IStage {
    protected Stage proxyObject;

    public StageProxy() {
        this.proxyObject = new Stage();
    }

    void setProxyObject(Stage proxyObject)
    {
        this.proxyObject = proxyObject;
    }

    public void setScene(SceneProxy scene)
    {
        proxyObject.setScene(scene.getProxyObject());
    }

    public void setResizable(boolean b) {
        proxyObject.setResizable(b);
    }

    public void setTitle(String s) {
        proxyObject.setTitle(s);
    }

    public void show() {
        proxyObject.show();
    }

    @Override
    protected Stage getProxyObject() {
        return proxyObject;
    }
}
