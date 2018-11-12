package com.pacgame.provider.layer;


import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.Color;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GroupLayerBuilder implements ILayerBuilder<GroupLayer> {

    private GroupLayer buildedEl;
    private Color color;


    @Override
    public GroupLayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return this;
    }

    @Override
    public GroupLayerBuilder textElement() {
        throw new NotImplementedException();
    }

    @Override
    public GroupLayerBuilder addChildren(ViewProvidedObject el) {
        buildedEl.addChildren(el);

        return this;
    }

    @Override
    public GroupLayer build() {
        this.buildedEl = new GroupLayer();

        return buildedEl;
    }

    @Override
    public GroupLayerBuilder color(Color color) {
        this.color = color;

        return this;
    }

}
