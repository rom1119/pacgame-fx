package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.Color;

public class RectangleBuilder implements ShapeBuilder<Rectangle> {

    private int width = 5;
    private int height = 5;

    private Color color;

    public RectangleBuilder with(int width, int height)
    {
        this.width = width;
        this.height = height;

        return this;
    }

    @Override
    public RectangleBuilder color(Color color) {
        this.color = color;

        return this;
    }

    @Override
    public Rectangle build() {
        Rectangle arc = new Rectangle(width, height);
        arc.setColor(color);
        return arc;
    }
}
