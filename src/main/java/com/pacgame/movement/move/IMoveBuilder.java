package com.pacgame.movement.move;

import com.pacgame.provider.IBuilder;

public interface IMoveBuilder<T extends IMove> extends IBuilder<T> {

    IMoveBuilder createMove();

}
