package com.pacgame.provider;

import com.pacgame.provider.alignment.PositionAlignment;

public class PositionAlignmentProviderImpl implements PositionAlignmentProvider {
    @Override
    public PositionAlignment topLeft() {
        return PositionAlignment.TOP_LEFT;
    }

    @Override
    public PositionAlignment topCenter() {
        return PositionAlignment.TOP_CENTER;
    }

    @Override
    public PositionAlignment topRight() {
        return PositionAlignment.TOP_RIGHT;
    }

    @Override
    public PositionAlignment centerLeft() {
        return PositionAlignment.CENTER_LEFT;
    }

    @Override
    public PositionAlignment center() {
        return PositionAlignment.CENTER;
    }

    @Override
    public PositionAlignment centerRight() {
        return PositionAlignment.CENTER_RIGHT;
    }

    @Override
    public PositionAlignment bottomLeft() {
        return PositionAlignment.BOTTOM_LEFT;
    }

    @Override
    public PositionAlignment bottomCenter() {
        return PositionAlignment.BOTTOM_CENTER;
    }

    @Override
    public PositionAlignment bottomRight() {
        return PositionAlignment.BOTTOM_RIGHT;
    }
}
