package com.pacgame.game.adapter.board;

import com.pacgame.game.board.model.level.IMapPoint;

public class MapPointAdapter implements IMapPoint {

    private int x;
    private int y;
    private IMapPoint left;
    private IMapPoint right;
    private IMapPoint up;
    private IMapPoint down;

    public MapPointAdapter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IMapPoint getLeft() {
        return left;
    }

    public void setLeft(IMapPoint left) {
        this.left = left;
    }

    public IMapPoint getRight() {
        return right;
    }

    public void setRight(IMapPoint right) {
        this.right = right;
    }

    public IMapPoint getUp() {
        return up;
    }

    public void setUp(IMapPoint up) {
        this.up = up;
    }

    public IMapPoint getDown() {
        return down;
    }

    public void setDown(IMapPoint down) {
        this.down = down;
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
