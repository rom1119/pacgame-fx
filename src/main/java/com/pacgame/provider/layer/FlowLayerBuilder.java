package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.ColorProvidedObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FlowLayerBuilder implements ILayerBuilder<FlowLayer> {

    private FlowLayer buildedEl;
    private String name;
    private ColorProvidedObject color;


    @Override
    public FlowLayer build() {
        this.buildedEl = new FlowLayer();

        return buildedEl;
    }

    @Override
    public FlowLayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return this;
    }

    @Override
    public FlowLayerBuilder textElement() {
        throw new NotImplementedException();
    }

    @Override
    public FlowLayerBuilder addChildren(ViewProvidedObject el) {
        buildedEl.addChildren(el);
        return this;
    }

    @Override
    public ILayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }

}
