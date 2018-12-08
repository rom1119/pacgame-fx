package com.pacgame.provider.color;

import static javafx.scene.paint.Color.rgb;

public class CustomColorProxy extends ColorProxy {

    public CustomColorProxy(int red, int green, int blue, double alpha) {
        proxyObject = rgb(red, green, blue, alpha);
    }

    public CustomColorProxy(int red, int green, int blue) {
        proxyObject = rgb(red, green, blue);
    }

}
