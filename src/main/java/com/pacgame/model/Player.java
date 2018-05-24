package com.pacgame.model;

import com.pacgame.Component;
import javafx.application.Platform;

public abstract class Player extends Component implements Moveable, Turnable {

    protected int checkedDirection = 0;
    protected boolean animated = false;

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public int getCheckedDirection() {
        return checkedDirection;
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

}
