package com.pacgame.model.point;

import com.pacgame.App;
import com.pacgame.Point;
import com.pacgame.event.PointEvent;
import com.pacgame.event.eventHandler.DestroyBigPoint;
import com.pacgame.event.eventHandler.DestroyNormalPoint;
import com.pacgame.model.Player;
import javafx.event.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class NormalPoint extends Point {

    protected static final String imageSrc = "./point/point.png";

    public NormalPoint(Point2D point, int size) {
        super(point, size, imageSrc);
        getCollider().addEventHandler(PointEvent.DESTROY, new DestroyNormalPoint());

    }

}
