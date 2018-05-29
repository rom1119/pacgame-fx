package com.pacgame.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Maze extends Player implements Eatable {

    protected int value = 10;
    protected final String mazeColor = "blue";
    protected boolean eatable = false;

    public Maze( Point2D point, int width, int height) {
        super();
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

    public void updateIcon()
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
    public void turnLeft() {
        if (!this.isEatable()) {
            updateIcon();
        }
    }

    @Override
    public void turnRight() {
        if (!this.isEatable()) {
            updateIcon();
        }
    }

    @Override
    public void turnUp() {
        if (!this.isEatable()) {
            updateIcon();
        }

    }

    @Override
    public void turnDown() {
        if (!this.isEatable()) {
            updateIcon();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean isEatable()
    {
        return eatable;
    }

    @Override
    public void setEatable(boolean isEatable)
    {
        this.eatable = isEatable;
    }
}
