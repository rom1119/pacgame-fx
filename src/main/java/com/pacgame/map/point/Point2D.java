package com.pacgame.map.point;

public class Point2D extends Point {

    protected Position2D position;

    public Point2D() {
        position = new Position2D(0, 0);
    }

    public Point2D(int x, int y) {
        position = new Position2D(x, y);
    }

    public Point2D(Position2D position1) {

        this.position = position1;
    }

    public int getX(){
        return position.getX();
    }

    public int getY(){
        return position.getY();
    }
}
