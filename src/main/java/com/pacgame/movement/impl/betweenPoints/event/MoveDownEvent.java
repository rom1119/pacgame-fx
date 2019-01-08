package com.pacgame.movement.impl.betweenPoints.event;

import com.pacgame.movement.impl.betweenPoints.direction.Move;

public class MoveDownEvent extends BaseMoveEventBetweenPoints {
    private static final String name = "MOVE_DOWN";


    @Override
    public String getName() {
        return name;
    }

    public MoveDownEvent() {
    }

    public MoveDownEvent(Object source, int fromX, int fromY) {
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
