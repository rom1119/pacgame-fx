package com.pacgame.gameElement;

import com.pacgame.provider.IShapeProvider;

public class GameElementFacade {

    private IShapeProvider shapeProvider;

    public GameElementFacade(IShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    public PointFactory pointFactory()
    {
        return new PointFactoryImpl(shapeProvider);
    }
}
