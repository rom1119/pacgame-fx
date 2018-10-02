package com.pacgame.board.model;

public interface Turnable {

    void turnLeft();

    void turnRight();

    void turnUp();

    void turnDown();

    boolean isTurnedTo(int direction);



}
