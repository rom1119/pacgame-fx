package com.pacgame.finder;

public interface FinderObject2D extends FinderObject {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();

    FindPoint2D getPoint();
}
