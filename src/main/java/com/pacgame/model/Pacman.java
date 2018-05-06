package com.pacgame.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Pacman extends Player implements Turnable, Moveable {
    protected Arc icon;

    public Pacman(Point2D point, int radius) {

        this.point = point;
        this.width = radius * 2;
        this.height = radius * 2;

        collider = new Rectangle(point.getX(), point.getY(), width, height);
//        icon = new Circle();

        collider.setFill(new Color(0, 1, 0, 0.7));

        this.icon = new Arc();
        this.icon.setCenterX(0);
        this.icon.setCenterY(0);
        this.icon.setRadiusX(radius);
        this.icon.setRadiusY(radius);
        this.icon.setStartAngle(45.0f);
        this.icon.setLength(270.0f);
        this.icon.setType(ArcType.ROUND);

        this.icon.setRotate(0);

        this.icon.setFill(Color.YELLOW);

        initPosition();

        turnUp();

        setCheckedDirection(Direction.UP);

//        moveDown(30);

//        this.icon.set

//        Image img = new Image("/image/rifat.jpg");
//        rectangle.setFill(new ImagePattern(img));

    }

    public boolean isTurnedTo(int side) {
        return this.getCheckedDirection() == side;
    }

    @Override
    public Arc getIcon() {
        return icon;
    }

    public void setIcon(Arc icon) {
        this.icon = icon;
    }

    private void setRotate(int angle)
    {
        this.getIcon().setRotate(angle);
        this.getCollider().setRotate(angle);
    }


    public void turnLeft() {
        this.setRotate(180);
    }

    public void turnRight() {
        this.setRotate(0);
    }

    public void turnUp() {
        this.setRotate(270);
    }

    public void turnDown() {
        this.setRotate(90);
    }

    protected void initPosition()
    {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY());

        collider.setLayoutX(point.getX() + (width / 2) - 1);
        collider.setLayoutY(point.getY() + (height / 2) - 1);

        icon.setTranslateX(point.getX() + (width));
        icon.setTranslateY(point.getY() + (height));

    }


    public void moveLeft(int step) {

        int x = 0;
        x = x - step;

        point = point.add(x, 0);
        collider.setTranslateX(point.getX());
        icon.setTranslateX(point.getX());
    }

    public void moveRight(int step) {

        int x = 0;
        x = x + step;

        point = point.add(x, 0);
        collider.setTranslateX(point.getX());
        icon.setTranslateX(point.getX());
    }

    public void moveUp(int step) {
        int y = 0;
        y = y - step;

        point = point.add(0, y);
        collider.setTranslateY(point.getY());
        icon.setTranslateY(point.getY());
    }


    /**
     * @param step
     */
    public void moveDown(int step) {



        int y = 0;
        y = y + step;

        point = point.add(0, y);
        collider.setTranslateY(point.getY());
        icon.setTranslateY(point.getY());


    }



}
