package com.pacgame.game.adapter.board;

import com.pacgame.game.board.model.level.IMapPoint;

public class MapPointAdapter implements IMapPoint {

    private int x;
    private int y;

    public MapPointAdapter(int x, int y) {
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
