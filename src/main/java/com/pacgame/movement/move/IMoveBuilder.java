package com.pacgame.movement.move;

import com.pacgame.provider.IBuilderProvider;

public interface IMoveBuilder<T extends IMove> extends IBuilderProvider<T> {

    IMoveBuilder createMove();

}
