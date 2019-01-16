package com.pacgame.movement.impl.pointToPoint.event;

import com.pacgame.movement.impl.pointToPoint.direction.Move;

public class AnyMoveEndEvent extends BaseMoveEventBetweenPoints {

    private static final String name = "ANY_MOVE";

    private int x;
    private int y;

    @Override
    public String getName() {
        return name;
    }

    public AnyMoveEndEvent() {
    }

    public AnyMoveEndEvent(Object source) {
        super(source);
        initEndCoordinatesValue();

    }

    protected void initEndCoordinatesValue() {
        if (getSource() instanceof Move) {
            Move move = (Move) getSource();
            if (move.getPoint() == null) {
                return;
            }

            x = move.getPoint().getX();
            y = move.getPoint().getY();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
