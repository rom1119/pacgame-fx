package com.pacgame.provider.color;

import com.pacgame.provider.Paint;
import com.pacgame.provider.Proxy;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class ImageFillProxy extends PaintProxy {

    public ImageFillProxy(String imgPath) {
        Image img = new Image(imgPath);
        proxyObject = new ImagePattern(img);
    }

}
