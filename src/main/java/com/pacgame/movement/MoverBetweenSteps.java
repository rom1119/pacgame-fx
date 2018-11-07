package com.pacgame.movement;

import com.pacgame.Movement;
import com.pacgame.movement.move.StepMoveBuilder;
import com.pacgame.provider.IMovementProvider;

public class MoverBetweenSteps extends Movement {
    private final StepMoveBuilder moveBuilder;

    public MoverBetweenSteps(IMovementProvider provider) {
        super(provider);
        this.moveBuilder = new StepMoveBuilder();
    }

    public void moveLeft()
    {

    }
}
