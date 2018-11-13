package com.pacgame.uiElement.layer;


import com.pacgame.View;
import com.pacgame.provider.ILayerProvider;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.Color;
import com.pacgame.uiElement.ILayerBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GroupLayerBuilder implements ILayerBuilder<GroupLayer> {

    private GroupLayer buildedEl;
    private Color color;

    private ILayerProvider layerProvider;

    public GroupLayerBuilder(ILayerProvider layerProvider) {
        this.layerProvider = layerProvider;
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
        this.buildedEl = new GroupLayer(layerProvider.groupLayerBuilder().build());

        return buildedEl;
    }

    @Override
    public GroupLayerBuilder color(Color color) {
        this.color = color;

        return this;
    }

}
