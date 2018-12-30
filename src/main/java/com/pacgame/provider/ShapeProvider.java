package com.pacgame.provider;

import com.pacgame.provider.component.shape.*;

public interface ShapeProvider{

    Arc createArc(int radius);
    Rectangle createRectangle(int width, int height);
    RectangleBuilder rectangleBuilder();
    ArcBuilder arcBuilder();
}
