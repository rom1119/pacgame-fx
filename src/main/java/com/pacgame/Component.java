package com.pacgame;

import com.pacgame.gameElement.Positionable;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public abstract class Component implements Positionable {

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
