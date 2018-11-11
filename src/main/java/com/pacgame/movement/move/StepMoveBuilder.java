package com.pacgame.movement.move;

import com.pacgame.movement.move.type.IStepMove;
import com.pacgame.movement.move.type.StepMove;

public class StepMoveBuilder implements IMoveBuilder<IStepMove> {

    private IStepMove buildedInstance;

    @Override
    public IStepMove build() {
        return buildedInstance;
    }

    @Override
    public IMoveBuilder createMove() {
        buildedInstance = new StepMove();
        return this;
    }
}
