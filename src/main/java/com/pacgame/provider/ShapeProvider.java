package com.pacgame.provider;

import com.pacgame.provider.component.shape.*;

public abstract class ShapeProvider {

    public abstract ArcBuilder arcBuilder();
    public abstract RectangleBuilder rectangleBuilder();
}
