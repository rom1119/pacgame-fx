package com.pacgame.provider.layer;

import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.provider.exception.NotImplementedException;

public class HorizontalLayerBuilder implements ILayerBuilder<HorizontalLayer> {

    private HorizontalLayer buildedEl;
    private String name;
    private ColorProvidedObject color;


    @Override
    public HorizontalLayer build() {
        this.buildedEl = new HorizontalLayer();

        return buildedEl;
    }

    @Override
    public HorizontalLayerBuilder with(int width, int height) {
        buildedEl.setWidth(width);
        buildedEl.setHeight(height);

        return this;
    }

    @Override
    public HorizontalLayerBuilder textElement() {
        throw new NotImplementedException();
    }

    @Override
    public HorizontalLayerBuilder addChildren(ViewProvidedObject el) {
        buildedEl.addChildren(el);
        return this;
    }

    @Override
    public HorizontalLayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }
}
