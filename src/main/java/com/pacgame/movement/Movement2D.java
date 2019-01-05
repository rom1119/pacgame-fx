package com.pacgame.movement;

public interface Movement2D extends Movement {

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    void moveTo(MovePoint2D point);
    void skipTo(MovePoint2D point);
}
