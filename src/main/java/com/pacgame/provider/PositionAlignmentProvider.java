package com.pacgame.provider;

import com.pacgame.provider.alignment.PositionAlignment;

public interface PositionAlignmentProvider {

    PositionAlignment topLeft();
    PositionAlignment topCenter();
    PositionAlignment topRight();

    PositionAlignment centerLeft();
    PositionAlignment center();
    PositionAlignment centerRight();

    PositionAlignment bottomLeft();
    PositionAlignment bottomCenter();
    PositionAlignment bottomRight();
}
