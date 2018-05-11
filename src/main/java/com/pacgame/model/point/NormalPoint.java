package com.pacgame.model.point;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;

public class NormalPoint extends Point {

    protected static final String imageSrc = "./point/point.png";

    public NormalPoint(Point2D point, int size) {
        super(point, size, imageSrc);

    }


}
