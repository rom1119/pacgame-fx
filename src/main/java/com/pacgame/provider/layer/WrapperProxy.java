package com.pacgame.provider.layer;

import com.pacgame.provider.IProxy;
import javafx.scene.Group;

public abstract class WrapperProxy implements IProxy {

    protected Group wrapper;

    public WrapperProxy() {
        this.wrapper = new Group();
    }
}
