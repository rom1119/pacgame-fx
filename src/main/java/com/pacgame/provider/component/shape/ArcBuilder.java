package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.ColorProvidedObject;

public class ArcBuilder implements ShapeBuilder<Arc> {

    private int radius = 10;

    private ColorProvidedObject color;

    public ArcBuilder radius(int radius)
    {
        this.radius = radius;

        return this;
    }

    @Override
    public ArcBuilder color(ColorProvidedObject color) {
        this.color = color;

        return this;
    }

    @Override
    public Arc build() {
        Arc arc = new Arc(radius);
        if (color != null) {
            arc.setBackground(color);

        }
        return arc;
    }
}
