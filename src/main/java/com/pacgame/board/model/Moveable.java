package com.pacgame.board.model;

public interface Moveable {

    void moveLeft(int step);
    void moveRight(int step);
    void moveUp(int step);
    void moveDown(int step) throws Exception;
}
