package com.pacgame.gameElement;

import com.pacgame.provider.ShapeProvider;

public class GameElementFacade {

    private ShapeProvider shapeProvider;

    public GameElementFacade(ShapeProvider shapeProvider) {
        this.shapeProvider = shapeProvider;
    }

    public PointFactory pointFactory()
    {
        return new PointFactoryImpl(shapeProvider);
    }
}
