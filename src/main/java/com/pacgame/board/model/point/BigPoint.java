package com.pacgame.board.model.point;

import com.pacgame.Point;
import com.pacgame.board.event.PointEvent;
import com.pacgame.board.event.eventHandler.OnDestroyBigPoint;
import javafx.geometry.Point2D;

public class BigPoint extends Point  {

    private final int value = 2;
    protected static final String imageSrc = "./point/big-point.png";

    public BigPoint(Point2D point, int size) {
        super(point, size, imageSrc);
        getCollider().addEventHandler(PointEvent.DESTROY, new OnDestroyBigPoint());
    }

    @Override
    public int getValue() {
        return value;
    }

}
