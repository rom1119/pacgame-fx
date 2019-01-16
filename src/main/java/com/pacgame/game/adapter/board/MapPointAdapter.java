package com.pacgame.game.adapter.board;

import com.pacgame.game.board.model.level.IMapPoint;

public class MapPointAdapter implements IMapPoint {

    private int x;
    private int y;
    private String name;
    private IMapPoint left;
    private IMapPoint right;
    private IMapPoint up;
    private IMapPoint down;
    private boolean door = false;

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

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return getName();
    }
}
