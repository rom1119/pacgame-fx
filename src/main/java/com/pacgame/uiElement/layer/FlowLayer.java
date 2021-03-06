package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;
import com.pacgame.uiElement.alignment.Position;

public class FlowLayer extends Layer {
    protected com.pacgame.provider.layer.FlowLayer providedObject;

    public FlowLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.providedObject = provider.createFlowLayer();
    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }

    public FlowLayer(LayerProvider provider) {
        super(provider);
        this.providedObject = provider.createFlowLayer();
    }

    public void setAlignment(Position position)
    {
        providedObject.setAlignment(position.getProvidedObject());
    }



//    @Override
//    public boolean isVisible() {
//        return providedObject.isVisible();
//    }
//
//    @Override
//    public void show() {
//        providedObject.show();
//    }
//
//    @Override
//    public void hide() {
//        providedObject.hide();
//    }
}
