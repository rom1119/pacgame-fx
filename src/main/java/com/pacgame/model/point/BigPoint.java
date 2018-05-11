package com.pacgame.model.point;

import javafx.geometry.Point2D;

public class BigPoint extends Point {

    private final int value = 2;
    protected static final String imageSrc = "./point/big-point.png";

    public BigPoint(Point2D point, int size) {
        super(point, size, imageSrc);
    }

    @Override
    public int getValue() {
        return value;
    }

}
