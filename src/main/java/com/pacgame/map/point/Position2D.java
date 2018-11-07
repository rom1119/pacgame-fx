package com.pacgame.map.point;

import com.pacgame.Positionable;

public class Position2D extends Position implements Positionable {

    private int x;
    private int y;

    public Position2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
