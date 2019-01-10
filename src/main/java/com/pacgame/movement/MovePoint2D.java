package com.pacgame.movement;

public interface MovePoint2D extends MovePoint {

    MovePoint2D getLeftPoint();
    MovePoint2D getRightPoint();
    MovePoint2D getUpPoint();
    MovePoint2D getDownPoint();

    int getX();
    int getY();
}
