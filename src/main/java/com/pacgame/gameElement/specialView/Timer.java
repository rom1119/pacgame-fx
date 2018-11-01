package com.pacgame.gameElement.specialView;

import com.pacgame.gameElement.GameSpecialView;
import com.pacgame.provider.ILayerProvider;

public class Timer extends GameSpecialView {

    private int INIT_SECOND = 5;

    public Timer(ILayerProvider layerProvider) {
        super(layerProvider);
    }

    @Override
    protected void createView() {
        this.getLayerProvider()
                .Builder()
                .borderLayer("timer")
                .with(width(200), height())
                .and()
                .textElement(String.valueOf(INIT_SECOND))
                .alignment()
                .build();

    }
}
