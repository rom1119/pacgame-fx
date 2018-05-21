package com.pacgame.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Maze extends Player {

    protected final String mazeColor = "blue";

    public Maze( Point2D point, int width, int height) {

        this.point = point;
        setWidth(width);
        setHeight(height);

        this.collider = new Rectangle(getWidth(), getHeight());
        collider.setFill(Color.TRANSPARENT);

        this.icon = new Rectangle(getWidth(), getHeight());
        Image img = new Image("./enemy/" + mazeColor + "/main.png");
        this.icon.setFill(new ImagePattern(img));

        initPosition();

        turnUp();

        setCheckedDirection(Direction.LEFT);
    }

    abstract String getIconPath(int direction);

    protected void updateIcon()
    {
        Image img = new Image(getIconPath(this.getCheckedDirection()));
        this.getIcon().setFill(new ImagePattern(img));
    }

    @Override
    public void initPosition() {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY() - getHeight() / 2);

        collider.setLayoutX(-(getWidth() / 3));
        collider.setLayoutY(-(getWidth() / 2));
        icon.setLayoutX(-(getWidth() / 3));
        icon.setLayoutY(-(getWidth() / 2));

        icon.setTranslateX(point.getX());
        icon.setTranslateY(point.getY() - getHeight() / 2);

    }

    @Override
    public void moveLeft(int step) {

        int x = 0;
        x = x + step;


        point = point.subtract(x, 0);
        updatePosition();
    }

    @Override
    public void moveRight(int step) {

        int x = 0;
        x = x + step;

        point = point.add(x, 0);
        updatePosition();
    }

    @Override
    public void moveUp(int step) {
        int y = 0;
        y = y + step;

        point = point.subtract(0, y);
        updatePosition();
    }


    @Override
    public void moveDown(int step) {

        int y = 0;
        y = y + step;

        point = point.add(0, y);
        updatePosition();


    }

    @Override
    public void turnLeft() {
        updateIcon();
    }

    @Override
    public void turnRight() {
        updateIcon();
    }

    @Override
    public void turnUp() {
        updateIcon();

    }

    @Override
    public void turnDown() {
        updateIcon();
    }
}
