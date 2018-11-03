package com.pacgame.provider.builder;

import com.pacgame.IBuilder;
import com.pacgame.IChildren;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.ViewProvidedObject;

public interface ILayerBuilder<T extends LayerProvidedObject> extends IBuilder<T>, IChildren<ViewProvidedObject> {


    ILayerBuilder create();
    ILayerBuilder with(int width, int height);
    ILayerBuilder name();
    ILayerBuilder and();
    ILayerBuilder textElement();

}
