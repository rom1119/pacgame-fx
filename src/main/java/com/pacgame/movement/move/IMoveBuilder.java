package com.pacgame.movement.move;

public interface IMoveBuilder<T extends IMove2D>  {

    IMoveBuilder createMove(Direction direction);

    T build();

}
