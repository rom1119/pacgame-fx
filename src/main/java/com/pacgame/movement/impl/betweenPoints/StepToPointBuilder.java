package com.pacgame.movement.impl.betweenPoints;

import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.direction.*;
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
            buildedInstance = new MoveUp(point.getUpPoint(), animationBuilder);
        } else if (direction.equals(Direction2D.DOWN)) {
            buildedInstance = new MoveDown(point.getDownPoint(), animationBuilder);
        } else if (direction.equals(Direction2D.LEFT)) {
            buildedInstance = new MoveLeft(point.getLeftPoint(), animationBuilder);
        } else {
            buildedInstance = new MoveRight(point.getRightPoint(), animationBuilder);
        }

        setPointIfNotNull(buildedInstance.getPoint());

        return this;
    }

    public void setPointIfNotNull(MovePoint2D point) {
        if (point != null) {
            System.out.println(point.getX());

            this.point = point;

        }
    }

    public boolean canCreateMove(Direction2D direction) {
        if (direction.equals(Direction2D.UP)) {
            return point.getUpPoint() != null;
        } else if (direction.equals(Direction2D.DOWN)) {
            return point.getDownPoint() != null;
        } else if (direction.equals(Direction2D.LEFT)) {
            return point.getLeftPoint() != null;
        } else if (direction.equals(Direction2D.RIGHT)) {
            return point.getRightPoint() != null;
        }

        return false;
    }
}
