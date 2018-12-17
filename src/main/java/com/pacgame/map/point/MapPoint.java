package com.pacgame.map.point;

public class MapPoint extends Point2D {

    private String name;
    private MapPoint upPoint ;
    private MapPoint DownPoint ;
    private MapPoint leftPoint ;
    private MapPoint rightPoint ;
    private boolean door = false;

    public MapPoint(Position2D position1) {
        super(position1);
    }

    public MapPoint(int x, int y) {
        this.position = new Position2D(x, y);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpPoint(MapPoint upPoint) {
        this.upPoint = upPoint;
    }

    public void setDownPoint(MapPoint downPoint) {
        DownPoint = downPoint;
    }

    public void setLeftPoint(MapPoint leftPoint) {
        this.leftPoint = leftPoint;
    }

    public void setRightPoint(MapPoint rightPoint) {
        this.rightPoint = rightPoint;
    }

    public void setDoor(boolean isDoor) {
        door = isDoor;
    }
}