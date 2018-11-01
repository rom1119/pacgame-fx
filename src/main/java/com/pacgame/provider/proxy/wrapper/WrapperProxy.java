package com.pacgame.provider.proxy.wrapper;

import com.pacgame.provider.IProxy;
import com.pacgame.provider.proxy.ViewProxy;
import javafx.scene.Group;

public abstract class WrapperProxy extends ViewProxy {

    protected Group wrapper;

    public WrapperProxy() {
        this.wrapper = new Group();
    }
}
