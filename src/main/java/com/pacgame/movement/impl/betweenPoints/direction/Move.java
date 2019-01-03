package com.pacgame.movement.impl.betweenPoints.direction;

import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.MoveEndHandler;
import com.pacgame.movement.move.type.IStepMove;
import com.pacgame.provider.animation.Animation;
import com.pacgame.provider.animation.AnimationBuilder;

public abstract class Move implements IStepMove {

    protected static final int DURATION = 600;

    protected MovePoint2D point;
    protected Animation animation;
    protected AnimationBuilder animationBuilder;

    public Move(MovePoint2D point, AnimationBuilder animationBuilder) {
        this.point = point;
        this.animationBuilder = animationBuilder;
    }

    @Override
    public boolean canMove() {
        return point != null;
    }

    public void start()
    {
        animation.play();
    }

    public void stop()
    {
        animation.pause();
    }

    public void setOnMoveEnd(MoveEndHandler handler) {
        animation.setOnFinished(e -> {
            handler.handle();
        });
    }
}
