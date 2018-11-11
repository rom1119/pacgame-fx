package com.pacgame.provider;

import com.pacgame.provider.component.shape.Arc;
import com.pacgame.provider.component.shape.Rectangle;
import com.pacgame.provider.component.shape.ShapeBuilder;

public interface IShapeProvider {

    ShapeBuilder<Arc> arcBuilder();
    ShapeBuilder<Rectangle> rectangleBuilder();
}
