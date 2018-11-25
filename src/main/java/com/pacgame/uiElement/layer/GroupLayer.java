package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;

public class GroupLayer extends Layer {

//    protected com.pacgame.provider.layer.GroupLayer providedObject;

    public GroupLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.providedObject = provider.createGroupLayer();

    }

    public GroupLayer(LayerProvider provider) {
        super(provider);
        this.providedObject = provider.createGroupLayer();

    }

//    @Override
//    protected LayerProvidedObject getProvidedObject() {
//        return providedObject;
//    }
//
//    @Override
//    public void setWidth(int width) {
//        super.setWidth(width);
//        providedObject.setWidth(width);
//    }
//
//    @Override
//    public void setHeight(int height) {
//        super.setHeight(height);
//        providedObject.setHeight(height);
//    }
}
