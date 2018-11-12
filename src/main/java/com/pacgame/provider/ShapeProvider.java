package com.pacgame.provider;

import com.pacgame.provider.component.shape.ArcBuilder;
import com.pacgame.provider.component.shape.RectangleBuilder;

public class ShapeProvider implements IShapeProvider {
    @Override
    public ArcBuilder arcBuilder() {
        return new ArcBuilder();
    }

    @Override
    public RectangleBuilder rectangleBuilder() {
        return new RectangleBuilder();
    }
}
