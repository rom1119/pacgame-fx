package com.pacgame.provider.color;

import com.pacgame.provider.Paint;

public class ImageFill extends Paint {
    protected ImageFillProxy proxy;

    public ImageFill(String imgPath) {
        proxy = new ImageFillProxy(imgPath);
    }

    @Override
    public ImageFillProxy getProxy() {
        return proxy;
    }

}
