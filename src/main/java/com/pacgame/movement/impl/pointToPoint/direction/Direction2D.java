package com.pacgame.movement.impl.pointToPoint.direction;

import com.pacgame.movement.move.Direction;

public class Direction2D implements Direction {

    public static final Direction2D UP = new Direction2D(0);
    public static final Direction2D DOWN = new Direction2D(1);
    public static final Direction2D LEFT = new Direction2D(2);
    public static final Direction2D RIGHT = new Direction2D(3);

    public int val;

    private Direction2D(int val) {
        this.val = val;
    }
}
