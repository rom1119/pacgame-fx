package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.provider.component.IComponentBuilder;
import com.pacgame.provider.component.ShapeProvidedObject;

public interface ShapeBuilder<T extends ShapeProvidedObject> extends IComponentBuilder<T> {

    ShapeBuilder color(ColorProvidedObject color);

    @Override
    T build();
}
