package com.pacgame.movement.impl.betweenPoints;

import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.direction.Direction2D;
import com.pacgame.movement.impl.betweenPoints.direction.MoveDown;
import com.pacgame.movement.impl.betweenPoints.direction.Move;
import com.pacgame.movement.move.Direction;
import com.pacgame.movement.move.IMoveBuilder;
import com.pacgame.provider.animation.AnimationBuilder;

class StepToPointBuilder implements IMoveBuilder<Move> {

    private MovePoint2D point;

    private AnimationBuilder animationBuilder;
    private Move buildedInstance;


    public StepToPointBuilder(MovePoint2D point, AnimationBuilder animationBuilder) {
        this.point = point;
        this.animationBuilder = animationBuilder;
    }

    @Override
    public Move build() {
        return buildedInstance;
    }

    @Override
    public IMoveBuilder<Move> createMove(Direction direction) {

        if (direction.equals(Direction2D.UP)) {
            buildedInstance = new MoveDown(point.getUpPoint(), animationBuilder);
        } else if (direction.equals(Direction2D.DOWN)) {
            buildedInstance = new MoveDown(point.getDownPoint(), animationBuilder);
        } else if (direction.equals(Direction2D.LEFT)) {
            buildedInstance = new MoveDown(point.getLeftPoint(), animationBuilder);
        } else {
            buildedInstance = new MoveDown(point.getRightPoint(), animationBuilder);
        }

        return this;
    }
}
