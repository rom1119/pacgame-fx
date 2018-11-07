package com.pacgame;

import com.pacgame.gameElement.MovedComponent;
import com.pacgame.provider.IMovementProvider;

public abstract class Movement {

    protected final int SPEED = 10;
    private IMovementProvider provider;

    public Movement(IMovementProvider provider) {
        this.provider = provider;
    }

}
