package com.pacgame.model.point;

import com.pacgame.Point;
import javafx.geometry.Point2D;

public class NormalPoint extends Point {

    protected static final String imageSrc = "./point/point.png";

    public NormalPoint(Point2D point, int size) {
        super(point, size, imageSrc);

    }


}
