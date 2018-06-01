package com.pacgame.service;

import com.pacgame.model.MapPoint;
import javafx.event.EventHandler;

public interface AnimationMoveHandler {

    void animationMoveEnd(MapPoint currentPoint);
}
