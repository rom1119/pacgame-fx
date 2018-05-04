package com.pacgame.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Maze extends Player {

    public Maze(String urlImage, Point2D point, int width, int height) {

        this.point = point;
        setWidth(width);
        setHeight(height);

        this.collider = new Rectangle();

        collider.setFill(Color.TRANSPARENT);

        this.icon = new Rectangle();

//        this.icon.set

        Image img = new Image(urlImage);
        this.icon.setFill(new ImagePattern(img));

        initPosition();
    }
}
