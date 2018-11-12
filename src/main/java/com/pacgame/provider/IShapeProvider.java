package com.pacgame.provider;

import com.pacgame.provider.component.shape.*;

public interface IShapeProvider {

    ArcBuilder arcBuilder();
    RectangleBuilder rectangleBuilder();
}
