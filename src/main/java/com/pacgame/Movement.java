package com.pacgame;

import com.pacgame.provider.MovementProvider;

public abstract class Movement {

    protected final int SPEED = 10;
    private MovementProvider provider;

    public Movement(MovementProvider provider) {
        this.provider = provider;
    }

}
