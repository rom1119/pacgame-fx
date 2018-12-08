package com.pacgame.gameElement.specialView;

import com.pacgame.gameElement.GameSpecialLayer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.uiElement.layer.GroupLayer;

public class Timer extends GameSpecialLayer {

    private int INIT_SECOND = 5;
    private com.pacgame.provider.layer.GroupLayer providedObject;

    public Timer(int width, int height, LayerProvider provider, UIProvider uiProvider) {
        super(width, height, provider);
        this.providedObject.setHeight(width);
        this.providedObject.setHeight(height);
        Label textElement = uiProvider.createTextElement(String.valueOf(INIT_SECOND));
        this.providedObject.addChildren(textElement);
    }


    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }
}
