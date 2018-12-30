package com.pacgame.map;

import com.pacgame.Layer;
import com.pacgame.color.ColorFactory;

public abstract class Map {

    protected String imgUrl;
    protected Layer rootLayer;
    protected ColorFactory colorFactory;

    public Map(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    public Layer getRootLayer() {
        return rootLayer;
    }

    public abstract String getInitialBackgroundUrl();

    public void setRootLayer(Layer rootLayer) {
        this.rootLayer = rootLayer;
        setImgUrl(getInitialBackgroundUrl());
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        updateBackground();
    }

    private void updateBackground()
    {
        if (rootLayer != null) {
            rootLayer.setBackground(colorFactory.image(imgUrl));

        }
    }
}
