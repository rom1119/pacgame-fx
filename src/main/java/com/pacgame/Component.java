package com.pacgame;


import com.pacgame.provider.IComponentProvider;

public abstract class Component extends View implements Positionable {

    private IComponentProvider provider;

    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public Component(int width, int height, IComponentProvider provider) {
        this.width = width;
        this.height = height;
        this.provider = provider;
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
