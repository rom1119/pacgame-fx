package com.pacgame.provider.layer;


import com.pacgame.provider.ViewProvidedObject;

public class GroupLayerBuilder implements ILayerBuilder<GroupLayer> {

    private GroupLayer buildedEl;

    @Override
    public ILayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return this;
    }

    @Override
    public ILayerBuilder textElement() {
        return this;
    }

    public void addChildren(ViewProvidedObject el) {
        buildedEl.addChildren(el);
    }

    @Override
    public GroupLayer build() {
        this.buildedEl = new GroupLayer();

        return buildedEl;
    }

}
