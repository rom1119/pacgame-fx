package com.pacgame.movement.impl.betweenPoints.event;

import com.pacgame.movement.event.MoveEvent;

abstract class BaseMoveEventBetweenPoints implements MoveEvent
{
    protected int fromX;
    protected int toX;
    protected int fromY;
    protected int toY;
    private Object source;

    public BaseMoveEventBetweenPoints(Object source, int fromX, int fromY) {
        this.source = source;
        this.fromX = fromX;
        this.fromY = fromY;
        initEndCoordinatesValue();
    }

    public BaseMoveEventBetweenPoints() {

    }

    public abstract String getName();

    protected abstract void initEndCoordinatesValue();

    public Object getSource() {
        return source;
    }

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
