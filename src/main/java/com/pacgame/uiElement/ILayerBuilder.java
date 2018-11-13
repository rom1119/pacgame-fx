package com.pacgame.uiElement;

import com.pacgame.IBuilder;
import com.pacgame.Layer;
import com.pacgame.View;
import com.pacgame.provider.color.Color;

public interface ILayerBuilder<T extends Layer> extends IBuilder {

    ILayerBuilder with(int width, int height);

    ILayerBuilder textElement();
    ILayerBuilder addChildren(View el);
    ILayerBuilder color(Color color);
}
