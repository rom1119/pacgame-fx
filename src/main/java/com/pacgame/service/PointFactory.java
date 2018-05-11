package com.pacgame.service;

import com.pacgame.model.point.BigPoint;
import com.pacgame.model.point.NormalPoint;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class PointFactory {

    private final int size = 2;

    public NormalPoint createNormalPoint(int x, int y)
    {
        return new NormalPoint(new Point2D(x, y), size);
    }

    public BigPoint createBigPoint(int x, int y)
    {
        return new BigPoint(new Point2D(x, y), size);
    }
}
