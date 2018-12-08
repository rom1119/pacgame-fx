package com.pacgame.uiElement.alignment;

import com.pacgame.provider.PositionAlignmentProvider;

public class PositionFactoryImpl implements PositionFactory {

    private PositionAlignmentProvider provider;

    public PositionFactoryImpl(PositionAlignmentProvider provider) {
        this.provider = provider;
    }

    @Override
    public Position topLeft() {
        return new Position(provider.topLeft());
    }

    @Override
    public Position topCenter() {
        return new Position(provider.topCenter());
    }

    @Override
    public Position topRight() {
        return new Position(provider.topRight());
    }

    @Override
    public Position centerLeft() {
        return new Position(provider.centerLeft());
    }

    @Override
    public Position center() {
        return new Position(provider.center());
    }

    @Override
    public Position centerRight() {
        return new Position(provider.centerRight());
    }

    @Override
    public Position bottomLeft() {
        return new Position(provider.bottomLeft());
    }

    @Override
    public Position bottomCenter() {
        return new Position(provider.bottomCenter());
    }

    @Override
    public Position bottomRight() {
        return new Position(provider.bottomRight());
    }
}
