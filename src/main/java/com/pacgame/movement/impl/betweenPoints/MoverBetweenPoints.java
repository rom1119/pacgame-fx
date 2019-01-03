package com.pacgame.movement.impl.betweenPoints;

import com.pacgame.movement.Movement2D;
import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.direction.*;
import com.pacgame.provider.animation.AnimationBuilder;

public class MoverBetweenPoints implements Movement2D {

    public static final Direction2D INITIAL_DIRECTION = Direction2D.RIGHT;

    private StepToPointBuilder moveBuilder;
    private AnimationBuilder animationBuilder;

    private Move currentDirectionMove;
    private ObjectMoving2D objectMoving;
    private Direction2D direction;
    private MovePoint2D initPoint;
    private boolean started;

    public MoverBetweenPoints(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving) {
        if (animationBuilder == null) {
            throw new NullPointerException("Animation Builder can not be null.");
        }

        if (animationBuilder == null) {
            throw new NullPointerException("Object Moving can not be null.");
        }

        if (animationBuilder == null) {
            throw new NullPointerException("Point initial can not be null.");
        }
        this.animationBuilder = animationBuilder;
        this.objectMoving = objectMoving;
        this.initPoint = initPoint;

        moveBuilder = new StepToPointBuilder(initPoint, animationBuilder);
        direction = INITIAL_DIRECTION;
    }

    public MoverBetweenPoints(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving, Direction2D direction) {
        this(animationBuilder, initPoint, objectMoving);
        this.direction = direction;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public void moveUp() {
        if (!isStarted()) {
            return;
        }
        direction = Direction2D.UP;
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveDown) {
            turnAround();
        }

    }



    @Override
    public void moveDown() {
        if (!isStarted()) {
            return;
        }
        direction = Direction2D.DOWN;
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveUp) {
            turnAround();
        }

    }

    @Override
    public void moveLeft()
    {
        if (!isStarted()) {
            return;
        }
        direction = Direction2D.LEFT;
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveRight) {
            turnAround();
        }
    }

    @Override
    public void moveRight() {
        if (!isStarted()) {
            return;
        }

        direction = Direction2D.RIGHT;
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveLeft) {
            turnAround();
        }
    }

    private void turnAround()
    {
        stop();
        go();
    }


    private void goIfIsSameStoped() {
        if (currentDirectionMove == null) {
            go();
        }
    }

    private void go() {
        currentDirectionMove = moveBuilder.createMove(direction).build();
        if (currentDirectionMove.canMove()) {
            currentDirectionMove.setOnMoveEnd(() -> {
                onEndMove();
            });
            currentDirectionMove.move(objectMoving);
        }


    }

    private void onEndMove()
    {
        if (!isStarted()) {
            return;
        }

        go();
    }

    @Override
    public void start() {
        started = true;
        go();
    }

    @Override
    public void stop() {
        started = false;
        currentDirectionMove.stop();
        currentDirectionMove = null;
    }

    @Override
    public void restart() {

    }

    @Override
    public void pause() {
        started = false;
        currentDirectionMove.stop();

    }
}
