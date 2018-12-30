package com.pacgame.gameElement;

import com.pacgame.gameElement.standElement.GamePoint;

public interface PointFactory {

    GamePoint createNormalPoint();
    GamePoint createBigPoint();

}
