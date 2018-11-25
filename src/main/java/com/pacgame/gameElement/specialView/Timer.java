package com.pacgame.gameElement.specialView;

import com.pacgame.gameElement.GameSpecialLayer;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.ui.text.Label;

public class Timer extends GameSpecialLayer {

    private int INIT_SECOND = 5;

    public Timer(int width, int height, LayerProvider provider, UIProvider uiProvider) {
        super(width, height, provider);
        this.providedObject.setHeight(width);
        this.providedObject.setHeight(height);
        Label textElement = uiProvider.createTextElement(String.valueOf(INIT_SECOND));
        this.providedObject.addChildren(textElement);
    }


}
