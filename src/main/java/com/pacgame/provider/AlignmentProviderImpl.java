package com.pacgame.provider;

import com.pacgame.provider.alignment.*;

public class AlignmentProviderImpl implements AlignmentProvider {
    @Override
    public VerticalAlignmentProvidedObject getTop() {
        return new Top();
    }

    @Override
    public VerticalAlignmentProvidedObject getVCenter() {
        return new VCenter();
    }

    @Override
    public VerticalAlignmentProvidedObject getBottom() {
        return new Bottom();
    }

    @Override
    public HorizontalAlignmentProvidedObject getLeft() {
        return new Left();
    }

    @Override
    public HorizontalAlignmentProvidedObject getHCenter() {
        return new HCenter();
    }

    @Override
    public HorizontalAlignmentProvidedObject getRight() {
        return new Right();
    }
}
