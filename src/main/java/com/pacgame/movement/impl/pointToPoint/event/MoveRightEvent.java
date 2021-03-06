package com.pacgame.movement.impl.pointToPoint.event;

import com.pacgame.movement.impl.pointToPoint.direction.Move;

public class MoveRightEvent extends MoveStartEvent {
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
