package com.pacgame.uiElement.layer;


import com.pacgame.View;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.uiElement.ILayerBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GroupLayerBuilder implements ILayerBuilder<GroupLayer> {

    private GroupLayer buildedEl;
    private ColorProvidedObject color;

    private LayerProvider layerProvider;

    public GroupLayerBuilder(LayerProvider layerProvider) {
        this.layerProvider = layerProvider;
        this.buildedEl = new GroupLayer(this.layerProvider);

    }

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
    public GroupLayerBuilder addChildren(View el) {
        buildedEl.addChildren(el);

        return this;
    }

    @Override
    public GroupLayer build() {

        return buildedEl;
    }

    @Override
    public GroupLayerBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }

}
