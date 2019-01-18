package com.pacgame.game.adapter.board.finder.shema.steps.maze;

import com.pacgame.finder.ObjectToFind2D;
import com.pacgame.game.adapter.board.MazeAdapter;
import com.pacgame.game.adapter.board.finder.rules.NotTurnAroundRule;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.scheme.SchemeStep;
import com.pacgame.scheme.SchemeStepHandler;

public class SecondStep implements SchemeStep<ObjectToFind2D> {

    private SchemeStepHandler onCompleteHandler;
    private ObjectToFind2D target;
    private IMaze finderObject;

    public SecondStep(ObjectToFind2D el, IMaze finderObject) {
        this.target = el;
        this.finderObject = finderObject;


    }

    @Override
    public ObjectToFind2D getTargetElement() {
        return target;
    }

    @Override
    public boolean isComplete() {
        return finderObject.getCurrentPoint().getX() == target.getPoint().getX() && finderObject.getCurrentPoint().getY() == target.getPoint().getY();
    }

    @Override
    public void update() {
    }

    @Override
    public void onComplete() {
        if (onCompleteHandler != null) {
            onCompleteHandler.handle();
        }
    }

    @Override
    public void setOnComplete(SchemeStepHandler handler) {
        this.onCompleteHandler = handler;
    }
}
