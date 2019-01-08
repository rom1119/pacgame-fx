package com.pacgame.movement.impl.betweenPoints.event;

import com.pacgame.movement.impl.betweenPoints.direction.Move;

public class MoveRightEvent extends BaseMoveEventBetweenPoints {
    private static final String name = "MOVE_RIGHT";


    @Override
    public String getName() {
        return name;
    }

    public MoveRightEvent() {
    }

    public MoveRightEvent(Object source, int fromX, int fromY) {
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
