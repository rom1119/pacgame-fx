package com.pacgame.gameElement.specialView;

import com.pacgame.gameElement.GameSpecialLayer;
import com.pacgame.provider.LayerProvider;

public class Timer extends GameSpecialLayer {

    private int INIT_SECOND = 5;

    public Timer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.providedObject.setHeight(width);
        this.providedObject.setHeight(height);

    }


}
