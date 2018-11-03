package com.pacgame.board.model;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Pacman extends Player implements Turnable {
    protected Arc icon;
    private SimpleStringProperty lives;

    public static final int INITIAL_LIVES = 5;

    public Pacman(Point2D point, int radius) {
        super();

        lives = new SimpleStringProperty();
        lives.set(String.valueOf(INITIAL_LIVES));
//        this.point = point;
//        this.width = radius * 2;
//        this.height = radius * 2;
//
//        collider = new Rectangle(point.getX(), point.getY(), width, height);
////        icon = new Circle();
//
////        collider.setFill(new Color(0, 1, 0, 0.7));
//        collider.setFill(Color.TRANSPARENT);
//
//        this.icon = new Arc();
//        this.icon.setCenterX(0);
//        this.icon.setCenterY(0);
//        this.icon.setRadiusX(radius);
//        this.icon.setRadiusY(radius);
//        this.icon.setStartAngle(45.0f);
//        this.icon.setLength(270.0f);
//        this.icon.setType(ArcType.ROUND);
//
//        this.icon.setRotate(0);
//
//        this.icon.setFill(Color.YELLOW);
//
//        initPosition();
//
//        turnUp();
//
//        setCheckedDirection(Direction.LEFT);

        setName("Pacman");


//        moveDown(30);

//        this.icon.set

//        Image img = new Image("/image/rifat.jpg");
//        rectangle.setFill(new ImagePattern(img));

    }

//    @Override
//    public void initPosition() {
//        collider.setTranslateX(point.getX());
//        collider.setTranslateY(point.getY());
//
//        collider.setLayoutX(point.getX() - (width / 2) - 1);
//        collider.setLayoutY(point.getY() - (height / 2) - 1);
//
//        icon.setTranslateX(point.getX() + (width));
//        icon.setTranslateY(point.getY() + (height));
//
//    }
//
//
//    @Override
//    public Arc getIcon() {
//        return icon;
//    }
//
//    public void setIcon(Arc icon) {
//        this.icon = icon;
//    }
//
//
//    @Override
//    public void moveLeft(int step) {
//
//        int x = 0;
//        x = x - step;
//
////        System.out.println(getCollider().getTranslateX());
////        System.out.println(getCollider().getTranslateY());
//        point = point.add(x, 0);
//
//        updatePosition();
//
//    }
//
//    @Override
//    public void moveRight(int step) {
//
//        int x = 0;
//        x = x + step;
//
//        point = point.add(x, 0);
//
//        updatePosition();
//    }
//
//    @Override
//    public void moveUp(int step) {
//        int y = 0;
//        y = y - step;
//
////        System.out.println(getCollider().getTranslateX());
////        System.out.println(getCollider().getTranslateY());
//
//        point = point.add(0, y);
//        updatePosition();
//    }
//
//
//    @Override
//    public void moveDown(int step) {
//
//        int y = 0;
//        y = y + step;
//
//        point = point.add(0, y);
//
//        updatePosition();
//
//
//    }
//
//    public void updatePosition()
//    {
//        Platform.runLater(new Runnable() {
//            public void run() {
//                collider.setTranslateX(point.getX());
//                collider.setTranslateY(point.getY());
//
//                icon.setTranslateX(point.getX());
//                icon.setTranslateY(point.getY());
//
//
//            }
//        });
//    }

    public String getLives() {
        return lives.get();
    }

    public SimpleStringProperty livesProperty() {
        return lives;
    }

    public void setLives(String lives) {
        this.lives.set(lives);
    }
}
