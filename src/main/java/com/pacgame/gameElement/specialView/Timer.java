package com.pacgame.gameElement.specialView;

import com.pacgame.gameElement.GameSpecialLayer;
import com.pacgame.provider.LayerProvider;

public class Timer extends GameSpecialLayer {

    private int INIT_SECOND = 5;

    public Timer(LayerProvider layerProvider) {
        super(layerProvider);
    }

    @Override
    protected void createView() {
        this.getProvider()
                .Builder()
                .name("timer")
                .with(width(200), height())
                .and()
                .textElement(String.valueOf(INIT_SECOND))
                .alignment()
                .build();

    }
}
