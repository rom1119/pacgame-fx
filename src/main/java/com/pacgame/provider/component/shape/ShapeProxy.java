package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.Color;
import com.pacgame.provider.component.ComponentProxy;
import javafx.scene.shape.Shape;

public abstract class ShapeProxy extends ComponentProxy {

    protected Shape proxyObject;

    @Override
    public void fill(int red, int green, int blue, double alpha) {
        proxyObject.setFill(javafx.scene.paint.Color.rgb(red, green, blue, alpha));
    }

    @Override
    public void fill(int red, int green, int blue) {
        proxyObject.setFill(javafx.scene.paint.Color.rgb(red, green, blue));
    }

    @Override
    public void fillRed() {

    }

    @Override
    public void fillBlue() {

    }

    @Override
    public void fillGreen() {

    }

    @Override
    public void fillWhite() {

    }

    @Override
    public void setColor(Color color) {

    }
}
