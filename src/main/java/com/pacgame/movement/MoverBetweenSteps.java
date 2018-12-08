package com.pacgame.movement;

import com.pacgame.Movement;
import com.pacgame.movement.move.StepMoveBuilder;
import com.pacgame.provider.MovementProvider;

public class MoverBetweenSteps extends Movement {
    private final StepMoveBuilder moveBuilder;

    public MoverBetweenSteps(MovementProvider provider) {
        super(provider);
        this.moveBuilder = new StepMoveBuilder();
    }

    public void moveLeft()
    {

    }
}
