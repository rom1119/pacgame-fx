package com.pacgame.movement.impl.betweenPoints.direction;

import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.MoveRule;
import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.impl.betweenPoints.MoveEndHandler;
import com.pacgame.movement.move.type.IStepMove;
import com.pacgame.provider.animation.Animation;
import com.pacgame.provider.animation.AnimationBuilder;

import java.util.List;

public abstract class Move implements IStepMove {

    public static final int DEFAULT_DURATION = 1000;
    protected static int DURATION;

    protected MovePoint2D point;
    protected Animation animation;
    protected AnimationBuilder animationBuilder;
    private List<MoveRule> rules;

    public Move(MovePoint2D point, AnimationBuilder animationBuilder) {
        this.point = point;
        this.animationBuilder = animationBuilder;
        setDefaultDuration();
    }

    public void setAsSkippedDuration()
    {
        DURATION = 0;
    }

    public void setDefaultDuration()
    {
        DURATION = DEFAULT_DURATION;
    }

    @Override
    public boolean canMove() {
        return point != null;
    }

    private boolean isSatisfiedByRules(MovePoint2D pointArg) {
        if (rules == null) {
            return true;
        }
//        System.out.println(rules.stream().allMatch(e -> e.isSatisfied(pointArg)));
        return rules.stream().allMatch(e -> e.isSatisfied(pointArg));
    }

    public MovePoint2D getPoint() {
        return point;
    }

    public void start()
    {
        animation.play();
    }

    public void stop()
    {
        if (animation != null) {
            animation.pause();

        }
    }

    public abstract void move(ObjectMoving2D objectMoving);

    public void setOnMoveEnd(MoveEndHandler handler) {
        animation.setOnFinished(e -> {
            handler.handle();
        });
    }

    public boolean canTurn(Direction2D direction) {
        MovePoint2D point = null;
        if (direction.equals(Direction2D.UP)) {
            point = this.point.getUpPoint();
        } else if (direction.equals(Direction2D.DOWN)) {
            point = this.point.getDownPoint();
        } else if (direction.equals(Direction2D.LEFT)) {
            point = this.point.getLeftPoint();
        } else if (direction.equals(Direction2D.RIGHT)) {
            point = this.point.getRightPoint();
        }

        return point != null && isSatisfiedByRules(point);
    }

    public void setRules(List<MoveRule> rules) {
        this.rules = rules;
    }
}
