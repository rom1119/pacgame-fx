package com.pacgame.movement.impl.pointToPoint.event;

import com.pacgame.movement.impl.pointToPoint.direction.Move;

public class MoveLeftEvent extends BaseMoveEventBetweenPoints {
    private static final String name = "MOVE_LEFT";


    @Override
    public String getName() {
        return name;
    }

    public MoveLeftEvent() {
    }

    public MoveLeftEvent(Object source, int fromX, int fromY) {
        super(source, fromX, fromY);
    }

    @Override
    protected void initEndCoordinatesValue() {
        if (getSource() instanceof Move) {
            Move move = (Move) getSource();
            if (move.getPoint() == null) {
                return;
            }

            toX = move.getPoint().getX();
            toY = move.getPoint().getY();
        }
    }
}
