package com.pacgame;

public abstract class Component extends View implements Positionable {

    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public Component(int width, int height) {
        this.width = width;
        this.height = height;
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
