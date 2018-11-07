package com.pacgame.provider.layer;

import com.pacgame.provider.IBuilder;
import com.pacgame.IChildren;
import com.pacgame.provider.ViewProvidedObject;

public interface ILayerBuilder<T extends LayerProvidedObject> extends IBuilder<T>, IChildren<ViewProvidedObject> {


    ILayerBuilder create();
    ILayerBuilder with(int width, int height);
    ILayerBuilder and();
    ILayerBuilder textElement();

}
