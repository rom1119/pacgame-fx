package com.pacgame.model;

import com.pacgame.Component;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public abstract class Player extends Component implements Moveable, Turnable {

    protected int checkedDirection = 0;
    protected boolean animated = false;
    private SimpleIntegerProperty speedMove;
    public final int INITIAL_SPEED = 10;
    protected String name;
    protected boolean isSelectFirstPoint;

    public Player() {
        speedMove = new SimpleIntegerProperty();
        speedMove.set(INITIAL_SPEED);
        setSelectFirstPoint(false);
    }

    public int getSpeedMove() {
        return speedMove.get();
    }

    public SimpleIntegerProperty speedMoveProperty() {
        return speedMove;
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove.set(speedMove);
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getCheckedDirection() {
        return checkedDirection;
    }

    public boolean isSelectFirstPoint() {
        return isSelectFirstPoint;
    }

    public void setSelectFirstPoint(boolean selectFirstPoint) {
        isSelectFirstPoint = selectFirstPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckedDirection(int checkedDirection) {
        if (checkedDirection < 0 || checkedDirection > 3) {
            throw new IllegalArgumentException();
        }

        this.checkedDirection = checkedDirection;
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

    public boolean isTurnedTo(int side) {
        return this.getCheckedDirection() == side;
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
//        System.out.println("aefsrgdfhg");

        point = point.add(0, y);
        collider.setTranslateY(point.getY());
        icon.setTranslateY(point.getY());
    }


    public void moveDown(int step) {

        int y = 0;
        y = y + step;

        point = point.add(0, y);
        collider.setTranslateY(point.getY());
        icon.setTranslateY(point.getY());


    }


    @Override
    public void initPosition() {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY());

        collider.setLayoutX(0);
        collider.setLayoutY(0);

        icon.setTranslateX(point.getX());
        icon.setTranslateY(point.getY());

    }

    public void setIconBackground(String url)
    {
        Image img = new Image(url);
        this.getIcon().setFill(new ImagePattern(img));
    }


}
