package com.pacgame.movement.impl.betweenPoints.direction;

import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.MoveEndHandler;
import com.pacgame.movement.move.type.IStepMove;
import com.pacgame.provider.animation.Animation;
import com.pacgame.provider.animation.AnimationBuilder;

public abstract class Move implements IStepMove {

    public static final int DEFAULT_DURATION = 1000;
    protected static int DURATION;

    protected MovePoint2D point;
    protected Animation animation;
    protected AnimationBuilder animationBuilder;

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

    public MovePoint2D getPoint() {
        return point;
    }

    public void start()
    {
        animation.play();
    }

    public void stop()
    {
        animation.stop();
    }

    public void setOnMoveEnd(MoveEndHandler handler) {
        animation.setOnFinished(e -> {
            handler.handle();
        });
    }
}
