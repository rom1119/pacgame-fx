package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.Color;

public class ArcBuilder implements ShapeBuilder<Arc> {

    private int radius = 10;

    private Color color;

    public ArcBuilder radius(int radius)
    {
        this.radius = radius;

        return this;
    }

    @Override
    public ArcBuilder color(Color color) {
        this.color = color;

        return this;
    }

    @Override
    public Arc build() {
        Arc arc = new Arc(radius);
        arc.setColor(color);
        return arc;
    }
}
