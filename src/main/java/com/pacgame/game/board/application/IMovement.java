package com.pacgame.game.board.application;


import com.pacgame.game.board.model.level.IMapPoint;

public interface IMovement {

    void start();

    void stop();

//    void restart();

    void pause();

    void skipTo(IMapPoint point);

    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();


}
