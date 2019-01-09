package com.pacgame.movement.impl.betweenPoints;

import com.pacgame.movement.Movement2D;
import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.betweenPoints.direction.*;
import com.pacgame.movement.impl.betweenPoints.event.MoverBetweenPointsEventFacade;
import com.pacgame.provider.animation.AnimationBuilder;

public class MoverBetweenPoints implements Movement2D {

    public static final Direction2D INITIAL_DIRECTION = Direction2D.LEFT;

    private StepToPointBuilder moveBuilder;
    private AnimationBuilder animationBuilder;

    private MoverBetweenPointsEventFacade movementEventFacade;

    private Move currentMove;
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
        this.movementEventFacade = new MoverBetweenPointsEventFacade();

        moveBuilder = new StepToPointBuilder(initPoint, animationBuilder, this.movementEventFacade);
        initDirections(INITIAL_DIRECTION);

    }

    public MoverBetweenPoints(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving, Direction2D currentDirection) {
        this(animationBuilder, initPoint, objectMoving);
        initDirections(currentDirection);
    }

    private void initDirections(Direction2D currentDirection)
    {
        if (currentDirection == null) {
            return;
        }
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

        checkDirection(Direction2D.UP);
        goIfIsSameStopped();

        if (currentMove instanceof MoveDown) {
            turnAround();
            return;
        }

    }



    @Override
    public void moveDown() {


        checkDirection(Direction2D.DOWN);
        goIfIsSameStopped();

        if (currentMove instanceof MoveUp) {
            turnAround();
            return;
        }

    }

    @Override
    public void moveLeft()
    {


        checkDirection(Direction2D.LEFT);
        goIfIsSameStopped();

        if (currentMove instanceof MoveRight) {
            turnAround();
            return;
        }

    }

    @Override
    public void moveRight() {


        checkDirection(Direction2D.RIGHT);
        goIfIsSameStopped();

        if (currentMove instanceof MoveLeft) {
            turnAround();
            return;
        }

    }

    private void turnAround()
    {
        stop();
        start();
    }

    private void goIfIsSameStopped() {
        if (!isStarted()) {
            started = true;
            go();
        }
    }

    private void tryTurn(){
        if (currentDirection == checkedDirection) {
            return;
        }

        if (currentMove.canTurn(checkedDirection)) {
            currentDirection = checkedDirection;
        }
    }

    private void go() {

        tryTurn();
        if (currentMove.canTurn(currentDirection)) {
            currentMove = moveBuilder.createMove(currentDirection).build();
            if (currentMove.canMove()) {
                currentMove.move(objectMoving);
                currentMove.setOnMoveEnd(() -> {
                    onEndMove();
                });
            }
        } else {
            started = false;
        }
    }

    private void skip() {
        currentMove = moveBuilder.createMove(currentDirection).build();
        if (currentMove.canMove()) {
            currentMove.setAsSkippedDuration();
            currentMove.move(objectMoving);
            currentMove.setOnMoveEnd(() -> {
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
        if (currentMove != null) {
            currentMove.stop();

        }
//        currentMove = null;
    }

    @Override
    public void restart() {

    }

    @Override
    public void pause() {
        started = false;
        currentMove.stop();

    }

    public MoverBetweenPointsEventFacade getEventFacade() {
        return movementEventFacade;
    }
}
