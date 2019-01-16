package com.pacgame.game.adapter.board.finder.shema;

import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.board.model.Moveable;

public interface SchemeStep {

    ObjectToFind2D getTargetElement();

    boolean isComplete();

    void update();

    void onComplete();

    void setOnComplete(SchemeStepHandler handler);
}
