package com.pacgame.color;

import com.pacgame.provider.PaintProvider;

public class ImageFill extends Paint {

    public ImageFill(PaintProvider provider, String imgPath) {
        super(provider);
        this.providedObject = provider.createImage(imgPath);
    }
}
