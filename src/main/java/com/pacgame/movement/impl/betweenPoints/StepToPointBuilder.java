package com.pacgame.movement.impl.betweenPoints;

import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.event.MovementEventFacade;
import com.pacgame.movement.impl.betweenPoints.direction.*;
import com.pacgame.movement.impl.betweenPoints.event.MoverBetweenPointsEventFacade;
import com.pacgame.movement.move.Direction;
import com.pacgame.movement.move.IMoveBuilder;
import com.pacgame.provider.animation.AnimationBuilder;

class StepToPointBuilder implements IMoveBuilder<Move> {

    private MovePoint2D point;

    private AnimationBuilder animationBuilder;
    private Move buildedInstance;
    private MoverBetweenPointsEventFacade movementEventFacade;


    public StepToPointBuilder(MovePoint2D point, AnimationBuilder animationBuilder, MoverBetweenPointsEventFacade movementEventFacade) {
        this.point = point;
        this.animationBuilder = animationBuilder;
        this.movementEventFacade = movementEventFacade;
    }

    @Override
    public Move build() {
        return buildedInstance;
    }

    @Override
    public IMoveBuilder<Move> createMove(Direction direction) {

        if (direction.equals(Direction2D.UP)) {
            buildedInstance = new MoveUp(point.getUpPoint(), animationBuilder, movementEventFacade);
        } else if (direction.equals(Direction2D.DOWN)) {
            buildedInstance = new MoveDown(point.getDownPoint(), animationBuilder, movementEventFacade);
        } else if (direction.equals(Direction2D.LEFT)) {
            buildedInstance = new MoveLeft(point.getLeftPoint(), animationBuilder, movementEventFacade);
        } else {
            buildedInstance = new MoveRight(point.getRightPoint(), animationBuilder, movementEventFacade);
        }

        setPointIfNotNull(buildedInstance.getPoint());

        return this;
    }

    public void setPointIfNotNull(MovePoint2D point) {
        if (point != null) {
            this.point = point;

        }
    }
}
