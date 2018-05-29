package com.pacgame.model.point;

import com.pacgame.App;
import com.pacgame.Point;
import com.pacgame.event.PointEvent;
import com.pacgame.event.eventHandler.DestroyBigPoint;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class BigPoint extends Point  {

    private final int value = 2;
    protected static final String imageSrc = "./point/big-point.png";

    public BigPoint(Point2D point, int size) {
        super(point, size, imageSrc);
        getCollider().addEventHandler(PointEvent.DESTROY, new DestroyBigPoint());
    }

    @Override
    public int getValue() {
        return value;
    }

}
