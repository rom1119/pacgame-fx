package com.pacgame.model;

import javafx.geometry.Point2D;

public class MapPoint extends Point2D {

    private MapPoint upPoint ;
    private MapPoint DownPoint ;
    private MapPoint leftPoint ;
    private MapPoint rightPoint ;
    /**
     * Creates a new instance of {@code Point2D}.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public MapPoint(double x, double y) {
        super(x, y);
    }

    public MapPoint add(double x, double y) {
        return new MapPoint(
                getX() + x,
                getY() + y);
    }

    public MapPoint subtract(double x, double y) {
        return new MapPoint(
                getX() - x,
                getY() - y);
    }

    public MapPoint getUpPoint() {
        return upPoint;
    }

    public void setUpPoint(MapPoint upPoint) {
        this.upPoint = upPoint;
    }

    public MapPoint getDownPoint() {
        return DownPoint;
    }

    public void setDownPoint(MapPoint downPoint) {
        DownPoint = downPoint;
    }

    public MapPoint getLeftPoint() {
        return leftPoint;
    }

    public void setLeftPoint(MapPoint leftPoint) {
        this.leftPoint = leftPoint;
    }

    public MapPoint getRightPoint() {
        return rightPoint;
    }

    public void setRightPoint(MapPoint rightPoint) {
        this.rightPoint = rightPoint;
    }
}