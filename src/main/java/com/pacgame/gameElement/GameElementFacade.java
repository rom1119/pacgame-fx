package com.pacgame.gameElement;

public class GameElementFacade {

    public GameElementFacade() {
    }

    public PointFactory pointFactory()
    {
        return new PointFactoryImpl();
    }
}
