package com.pacgame.map.point;

import com.pacgame.Positionable;
import com.pacgame.Property;

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

    @Override
    public Property<Integer> XProperty() {
        return null;
    }

    @Override
    public Property<Integer> YProperty() {
        return null;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }


}
