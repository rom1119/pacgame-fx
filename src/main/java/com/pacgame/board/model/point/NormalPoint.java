package com.pacgame.board.model.point;

import com.pacgame.board.event.PointEvent;
import com.pacgame.board.event.eventHandler.OnDestroyNormalPoint;
import javafx.geometry.Point2D;

public class NormalPoint extends Point {

    protected static final String imageSrc = "./point/point.png";

    public NormalPoint(Point2D point, int size) {
        super(point, size, imageSrc);
        getCollider().addEventHandler(PointEvent.DESTROY, new OnDestroyNormalPoint());

    }

}
