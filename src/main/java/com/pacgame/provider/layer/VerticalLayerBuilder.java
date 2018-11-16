package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.ColorProvidedObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class VerticalLayerBuilder implements ILayerBuilder<VerticalLayer> {

    private VerticalLayer buildedEl;
    private String name;
    private ColorProvidedObject color;


    @Override
    public VerticalLayer build() {
        this.buildedEl = new VerticalLayer();

        return buildedEl;
    }

    @Override
    public VerticalLayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return this;
    }

    @Override
    public FlowLayerBuilder textElement() {
        throw new NotImplementedException();
    }

    @Override
    public VerticalLayerBuilder addChildren(ViewProvidedObject el) {
        buildedEl.addChildren(el);
        return this;
    }

    @Override
    public VerticalLayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }
}
