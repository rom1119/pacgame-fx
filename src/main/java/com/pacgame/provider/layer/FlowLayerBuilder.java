package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.layer.ILayerBuilder;
import com.pacgame.provider.layer.FlowLayer;

import java.util.Map;

public class FlowLayerBuilder implements ILayerBuilder<FlowLayer> {

    private FlowLayer buildedObject;
    private String name;
    @Override
    public FlowLayer build() {
        return buildedObject;
    }

    @Override
    public FlowLayer buildedObject() {
        return null;
    }

    @Override
    public ILayerBuilder create() {
        this.buildedObject = new FlowLayer();
        return this;
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
}
