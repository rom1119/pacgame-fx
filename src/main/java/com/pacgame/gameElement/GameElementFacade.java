package com.pacgame.gameElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.provider.ShapeProvider;

public class GameElementFacade {

    private ShapeProvider shapeProvider;
    private ColorFactory colorFactory;

    public GameElementFacade(ShapeProvider shapeProvider, ColorFactory colorFactory) {
        this.shapeProvider = shapeProvider;
        this.colorFactory = colorFactory;
    }

    public PointFactory pointFactory()
    {
        return new PointFactoryImpl(shapeProvider, colorFactory);
    }
}
