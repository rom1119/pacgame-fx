package com.pacgame.provider.color;

import com.pacgame.provider.Proxy;

public class ImageFill extends Paint {
    protected ImageFillProxy proxy;

    public ImageFill(String imgPath) {
        proxy = new ImageFillProxy(imgPath);
    }

    @Override
    protected ImageFillProxy getProxy() {
        return proxy;
    }
}
