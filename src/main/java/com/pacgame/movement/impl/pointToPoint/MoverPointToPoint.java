package com.pacgame.movement.impl.pointToPoint;

import com.pacgame.movement.MoveRule;
import com.pacgame.movement.Movement2D;
import com.pacgame.movement.ObjectMoving2D;
import com.pacgame.movement.MovePoint2D;
import com.pacgame.movement.impl.pointToPoint.direction.*;
import com.pacgame.movement.impl.pointToPoint.event.MoverBetweenPointsEventFacade;
import com.pacgame.provider.animation.AnimationBuilder;

import java.util.ArrayList;
import java.util.List;

public class MoverPointToPoint implements Movement2D {

    public static final Direction2D INITIAL_DIRECTION = Direction2D.RIGHT;

    private StepToPointBuilder moveBuilder;
    private AnimationBuilder animationBuilder;

    private MoverBetweenPointsEventFacade movementEventFacade;

    private Move currentMove;
    private ObjectMoving2D objectMoving;
    private Direction2D currentDirection;
    private Direction2D checkedDirection;
    private MovePoint2D initPoint;
    private boolean started;
    private List<MoveRule> rules;

    public MoverPointToPoint(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving) {
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
        this.rules = new ArrayList<>();

        moveBuilder = new StepToPointBuilder(initPoint, animationBuilder, this.movementEventFacade);
        initDirections(INITIAL_DIRECTION);
        currentMove = moveBuilder.createMove(currentDirection).build();


    }

    public MoverPointToPoint(AnimationBuilder animationBuilder, MovePoint2D initPoint, ObjectMoving2D objectMoving, Direction2D currentDirection) {
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
        if (currentMove.isEnded()) {
//            System.out.println("go");
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

    public int calculateMoveDuration()
    {

        if (currentDirection == Direction2D.UP  || currentDirection == Direction2D.DOWN) {
            int translateYObject = objectMoving.YAxisProperty().get();
            int pointY = currentMove.getPoint().getY();

//            System.out.println(pointY - translateYObject);

            return getSpeedMove() * Math.abs( translateYObject - pointY) ;
        } else {
            int translateXObject = objectMoving.XAxisProperty().get();
            int pointX = currentMove.getPoint().getX();
            return getSpeedMove() * Math.abs( translateXObject - pointX) ;
        }
    }

    private int getSpeedMove() {
        return 20;
    }

    private void go() {

        tryTurn();
        if (currentMove.canTurn(currentDirection)) {
            currentMove = moveBuilder.createMove(currentDirection).build();
            currentMove.setRules(rules);
            currentMove.setDurationMoveInMilliseconds(getSpeed());
            if (currentMove.canMove()) {
                currentMove.move(objectMoving);
                currentMove.setOnMoveEnd(() -> {
                    emitEndMoveEvent();
                    goIfIsSameStopped();
                });
            }
        } else {
            started = false;
        }
    }

    private int getSpeed() {
//        System.out.println(calculateMoveDuration());
        return calculateMoveDuration();
    }

    private void skip() {
        currentMove = moveBuilder.createMove(currentDirection).build();
        if (currentMove.canMove()) {
            currentMove.setAsSkippedDuration();
            currentMove.move(objectMoving);
            currentMove.setOnMoveEnd(() -> {
                emitEndMoveEvent();
                continueMoveIfIsPossible();
            });
        } else {
            started = false;
        }
    }

    private void emitEndMoveEvent() {
        movementEventFacade.emitEvent(movementEventFacade.createAnyMoveEndEvent(currentMove));

    }

    private void continueMoveIfIsPossible()
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

    public void addRule(MoveRule rule)
    {
        this.rules.add(rule);
    }

    public void removeRule(MoveRule rule)
    {
        this.rules.remove(rule);
    }

    public MoverBetweenPointsEventFacade getEventFacade() {
        return movementEventFacade;
    }
}
