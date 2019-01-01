package com.pacgame.gameElement;

import com.pacgame.color.ColorFactory;
import com.pacgame.provider.AnimationProvider;
import com.pacgame.provider.ShapeProvider;

public class GameElementFacade {

    private ShapeProvider shapeProvider;
    private ColorFactory colorFactory;
    private AnimationProvider animationProvider;

    public GameElementFacade(ShapeProvider shapeProvider, ColorFactory colorFactory, AnimationProvider animationProvider) {
        this.shapeProvider = shapeProvider;
        this.colorFactory = colorFactory;
        this.animationProvider = animationProvider;
    }

    public PointFactory pointFactory()
    {
        return new PointFactoryImpl(shapeProvider, colorFactory);
    }

    public MovingElementFactory movingElementFactory()
    {
        return new MovingElementFactoryImpl(shapeProvider, colorFactory, animationProvider);
    }
}
