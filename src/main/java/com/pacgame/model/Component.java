package com.pacgame.model;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;

public abstract class Component {

    protected Point2D point;
    protected int width;
    protected int height;
    protected Shape collider;
    protected Shape icon;

    public Shape getCollider() {
        return collider;
    }

    public void setCollider(Shape collider) {
        this.collider = collider;
    }

    public Shape getIcon() {
        return icon;
    }

    public void setIcon(Shape icon) {
        this.icon = icon;
    }


    public Point2D getPoint() {
        return point;
    }

    public void setPoint(Point2D point) {
        this.point = point;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws IllegalArgumentException {

        if (width < 1) {
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws IllegalArgumentException {

        if (height < 1) {
            throw new IllegalArgumentException();
        }

        this.height = height;
    }

    public boolean cont(Component el)
    {


//        element.contains(el.getElement().get, )

        return true;
    }

//    protected void initPosition()
//    {
//        collider.setTranslateX(point.getX());
//        collider.setTranslateY(point.getY());
//
//        icon.setTranslateX(point.getX());
//        icon.setTranslateY(point.getY());
//
//
//    }

    protected void initPosition()
    {
        collider.setTranslateX(point.getX());
        collider.setTranslateY(point.getY());

        collider.setLayoutX(point.getX() - (width / 2) - 1);
        collider.setLayoutY(point.getY() - (height / 2) - 1);

        icon.setTranslateX(point.getX() + (width));
        icon.setTranslateY(point.getY() + (height));

    }
}
