package com.pacgame.uiElement.layer;

import com.pacgame.Layer;
import com.pacgame.provider.LayerProvidedObject;
import com.pacgame.provider.LayerProvider;

public class GroupLayer extends Layer {

    protected com.pacgame.provider.layer.GroupLayer providedObject;

    public GroupLayer(int width, int height, LayerProvider provider) {
        super(width, height, provider);
        this.providedObject = provider.createGroupLayer();

    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }

    public GroupLayer(LayerProvider provider) {
        super(provider);
        this.providedObject = provider.createGroupLayer();

    }


}
