package com.pacgame.movement.impl.betweenPoints;

import com.pacgame.movement.Movement2D;
import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.direction.*;
import com.pacgame.provider.animation.AnimationBuilder;

public class MoverBetweenPoints implements Movement2D {

    public static final Direction2D INITIAL_DIRECTION = Direction2D.LEFT;

    private StepToPointBuilder moveBuilder;
    private AnimationBuilder animationBuilder;

    private Move currentDirectionMove;
    private ObjectMoving2D objectMoving;
    private Direction2D currentDirection;
    private Direction2D checkedDirection;
    private MovePoint2D initPoint;
    private boolean started;

    public MoverBetweenPoints(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving) {
        if (animationBuilder == null) {
            throw new NullPointerException("Animation Builder can not be null.");
        }

        if (objectMoving == null) {
            throw new NullPointerException("Object Moving can not be null.");
        }

        if (initPoint == null) {
            throw new NullPointerException("Point initial can not be null.");
        }
        this.animationBuilder = animationBuilder;
        this.objectMoving = objectMoving;
        this.initPoint = initPoint;

        moveBuilder = new StepToPointBuilder(initPoint, animationBuilder);
        currentDirection = INITIAL_DIRECTION;
        checkedDirection = INITIAL_DIRECTION;
    }

    public MoverBetweenPoints(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving, Direction2D currentDirection) {
        this(animationBuilder, initPoint, objectMoving);
        this.currentDirection = currentDirection;
        this.checkedDirection = currentDirection;
    }

     @Override
     public void moveTo(MovePoint2D point)
     {
         stop();
         moveBuilder.setPointIfNotNull(point);
         start();
     }

    @Override
    public void skipTo(MovePoint2D point) {
        stop();
        moveBuilder.setPointIfNotNull(point);
        skip();
    }



    public boolean isStarted() {
        return started;
    }

    @Override
    public void moveUp() {
        if (!isStarted()) {
            return;
        }
        checkDirection(Direction2D.UP);
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveDown) {
            turnAround();
            return;
        }

    }



    @Override
    public void moveDown() {
        if (!isStarted()) {
            return;
        }

        checkDirection(Direction2D.DOWN);
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveUp) {
            turnAround();
            return;
        }

    }

    @Override
    public void moveLeft()
    {
        if (!isStarted()) {
            return;
        }

        checkDirection(Direction2D.LEFT);
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveRight) {
            turnAround();
            return;
        }

    }

    @Override
    public void moveRight() {
        if (!isStarted()) {
            return;
        }

        checkDirection(Direction2D.RIGHT);
        goIfIsSameStoped();

        if (currentDirectionMove instanceof MoveLeft) {
            turnAround();
            return;
        }

    }

    private void turnAround()
    {
        stop();
        start();
    }

    private void goIfIsSameStoped() {
        if (currentDirectionMove == null) {
            go();
        }
    }

    private void tryTurn(){
        if (moveBuilder.canCreateMove(checkedDirection)) {
            currentDirection = checkedDirection;
        }
    }

    private void go() {

        tryTurn();
        currentDirectionMove = moveBuilder.createMove(currentDirection).build();
        if (currentDirectionMove.canMove()) {
            currentDirectionMove.move(objectMoving);
            currentDirectionMove.setOnMoveEnd(() -> {
                onEndMove();
            });
        } else {
            currentDirectionMove = null;
        }
    }

    private void skip() {
        currentDirectionMove = moveBuilder.createMove(currentDirection).build();
        if (currentDirectionMove.canMove()) {
            currentDirectionMove.setAsSkippedDuration();
            currentDirectionMove.move(objectMoving);
            currentDirectionMove.setOnMoveEnd(() -> {
                onEndMove();
            });
        }
    }

    private void onEndMove()
    {
        if (!isStarted()) {
            return;
        }

        go();
    }

    private void checkDirection(Direction2D direction)
    {
        checkedDirection = direction;
    }

    @Override
    public void start() {
        started = true;
        go();
    }

    @Override
    public void stop() {
        started = false;
        if (currentDirectionMove != null) {
            currentDirectionMove.stop();

        }
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
