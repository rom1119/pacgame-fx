package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.uiElement.alignment.Position;

public class VerticalLayer extends Layer {

    protected com.pacgame.provider.layer.VerticalLayer providedObject;

    public VerticalLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.providedObject = provider.createVerticalLayer();

    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }

    public VerticalLayer(LayerProvider provider) {
        super(provider);
        this.providedObject = provider.createVerticalLayer();

    }

    public void setAlignment(Position position)
    {
        providedObject.setAlignment(position.getProvidedObject());
    }

//    @Override
//    protected ViewProvidedObject getProvidedObject() {
//        return providedObject;
//    }
}
