package com.pacgame.provider.layer;

import com.pacgame.provider.IBuilderProvider;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.color.Color;

public interface ILayerBuilder<T extends LayerProvidedObject> extends IBuilderProvider<T> {


    ILayerBuilder with(int width, int height);

    ILayerBuilder textElement();
    ILayerBuilder addChildren(ViewProvidedObject el);
    ILayerBuilder color(Color color);


}
