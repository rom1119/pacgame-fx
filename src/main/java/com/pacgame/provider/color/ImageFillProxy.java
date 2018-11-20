package com.pacgame.provider.color;

import com.pacgame.provider.Proxy;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class ImageFillProxy extends Proxy {

    protected ImagePattern proxyObject;

    public ImageFillProxy(String imgPath) {
        Image img = new Image(imgPath);
        proxyObject = new ImagePattern(img);
    }

    public ImagePattern getProxyObject()
    {
        return proxyObject;
    }
}
