package com.pacgame.provider.layer;


import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.provider.exception.NotImplementedException;

public class GroupLayerBuilder implements ILayerBuilder<GroupLayer> {

    private GroupLayer buildedEl;
    private ColorProvidedObject color;


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
    public GroupLayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }

}
