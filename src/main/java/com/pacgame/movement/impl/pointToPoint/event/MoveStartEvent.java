package com.pacgame.movement.impl.pointToPoint.event;

public abstract class MoveStartEvent extends BaseMoveEventBetweenPoints {

    protected int fromX;
    protected int toX;
    protected int fromY;
    protected int toY;

    public MoveStartEvent(Object source, int fromX, int fromY) {
        super(source);
        this.fromX = fromX;
        this.fromY = fromY;
        initEndCoordinatesValue();
    }

    public MoveStartEvent() {

    }

    protected abstract void initEndCoordinatesValue();


    public int getFromX() {
        return fromX;
    }

    public int getToX() {
        return toX;
    }

    public int getFromY() {
        return fromY;
    }

    public int getToY() {
        return toY;
    }

    void setFromX(int fromX) {
        this.fromX = fromX;
    }

    void setFromY(int fromY) {
        this.fromY = fromY;
    }
}
