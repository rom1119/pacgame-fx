package com.pacgame.provider;

import com.pacgame.provider.component.shape.Arc;
import com.pacgame.provider.component.shape.ArcBuilder;
import com.pacgame.provider.component.shape.Rectangle;
import com.pacgame.provider.component.shape.RectangleBuilder;

public class ShapeProviderImpl implements ShapeProvider {

    private ArcBuilder arcBuilder;
    private RectangleBuilder rectangleBuilder;

    public ShapeProviderImpl() {
        arcBuilder = new ArcBuilder();
        rectangleBuilder = new RectangleBuilder();
    }

    @Override
    public Arc createArc(int radius) {

        return arcBuilder.radius(radius)
                .build();

    }

    @Override
    public Rectangle createRectangle(int width, int height) {
        return rectangleBuilder.with(width, height)
                .build();
    }

    @Override
    public RectangleBuilder rectangleBuilder() {
        return rectangleBuilder;
    }

    @Override
    public ArcBuilder arcBuilder() {
        return arcBuilder;
    }
}
