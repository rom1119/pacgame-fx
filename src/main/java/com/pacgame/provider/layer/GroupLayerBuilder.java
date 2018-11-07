package com.pacgame.provider.layer;


import com.pacgame.provider.ViewProvidedObject;

import java.util.Map;

public class GroupLayerBuilder implements ILayerBuilder<GroupLayer> {
    @Override
    public ILayerBuilder create() {
        return null;
    }

    @Override
    public ILayerBuilder with(int width, int height) {
        return null;
    }

    @Override
    public ILayerBuilder and() {
        return null;
    }

    @Override
    public ILayerBuilder textElement() {
        return null;
    }

    @Override
    public Map<String, ViewProvidedObject> getChildren() {
        return null;
    }

    @Override
    public void addChildren(ViewProvidedObject el) {

    }

    @Override
    public void removeChildren(ViewProvidedObject el) {

    }

    @Override
    public boolean hasChildren(ViewProvidedObject el) {
        return false;
    }

    @Override
    public GroupLayer build() {
        return null;
    }

    @Override
    public GroupLayer buildedObject() {
        return null;
    }
}
