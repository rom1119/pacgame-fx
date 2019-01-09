package com.pacgame.game.adapter.board.movement;

import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.movement.MovePoint2D;

public class MovePoint2DAdapter implements MovePoint2D {

    private int x;
    private int y;
    private MovePoint2D left;
    private MovePoint2D right;
    private MovePoint2D up;
    private MovePoint2D down;
    private boolean door = false;


    public MovePoint2DAdapter(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setLeft(MovePoint2D left) {
        this.left = left;
    }

    public void setRight(MovePoint2D right) {
        this.right = right;
    }

    public void setUp(MovePoint2D up) {
        this.up = up;
    }

    public void setDown(MovePoint2D down) {
        this.down = down;
    }

    @Override
    public MovePoint2D getLeftPoint() {
        return left;
    }

    @Override
    public MovePoint2D getRightPoint() {
        return right;
    }

    @Override
    public MovePoint2D getUpPoint() {
        return up;
    }

    @Override
    public MovePoint2D getDownPoint() {
        return down;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }
}
