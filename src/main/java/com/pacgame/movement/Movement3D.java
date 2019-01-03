package com.pacgame.movement;

public interface Movement3D extends Movement {

    void moveLeft();
    void moveRight();
    void moveForward();
    void moveBack();

    void turnUp();
    void turnDown();
    void turnLeft();
    void turnRight();
}
