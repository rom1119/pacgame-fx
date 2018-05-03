package com.pacgame.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;

public class Pacman extends Player implements Turnable, Moveable {
    protected Arc icon;

    @Override
    public Arc getIcon() {
        return icon;
    }

    public void setIcon(Arc icon) {
        this.icon = icon;
    }


    public Pacman(Point2D point, int radius) {

        this.point = point;
        this.width = radius;
        this.height = radius;

        collider = new Rectangle();
//        icon = new Circle();

        collider.setFill(Color.TRANSPARENT);

        this.icon = new Arc();
        this.icon.setCenterX(0);
        this.icon.setCenterY(0);
        this.icon.setRadiusX(25.0f);
        this.icon.setRadiusY(25.0f);
        this.icon.setStartAngle(45.0f);
        this.icon.setLength(270.0f);
        this.icon.setType(ArcType.ROUND);

        this.icon.setFill(Color.YELLOW);



        initPosition();

        moveDown(30);

//        this.icon.set

//        Image img = new Image("/image/rifat.jpg");
//        rectangle.setFill(new ImagePattern(img));

    }

    public void turnLeft() {
        this.getIcon().setRotate(90);
    }

    public void turnRight() {
        this.getIcon().setRotate(270);
    }

    public void turnUp() {
        this.getIcon().setRotate(0);
    }

    public void turnDown() {
        this.getIcon().setRotate(180);
    }

    protected void initPosition()
    {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY());

        icon.setTranslateX(point.getX());
        icon.setTranslateY(point.getY());

    }


    public void moveLeft(int step) {

        int x = (int) point.getX();
        x = x - step;

        int currentPointY = (int) point.getY();

        point = point.add(x, currentPointY);
        collider.setTranslateX(x);
        icon.setTranslateX(x);
    }

    public void moveRight(int step) {

        int x = (int) point.getX();
        x = x + step;

        int currentPointY = (int) point.getY();


        point = point.add(x, currentPointY);
        collider.setTranslateX(x);
        icon.setTranslateX(x);
    }

    public void moveUp(int step) {
        int y = (int) point.getY();
        y = y - step;

        int currentPointX = (int) point.getX();


        point = point.add(currentPointX, y);
        collider.setTranslateY(y);
        icon.setTranslateY(y);
    }


    /**
     * @param step
     */
    public void moveDown(int step) {



        int y = (int) point.getY();
        y = y - step;

        int currentPointX = (int) point.getX();


        point = point.add(currentPointX, y);
        collider.setTranslateY(y);
        icon.setTranslateY(y);


    }



}
