package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.ColorProvidedObject;
import com.pacgame.provider.component.ComponentProxy;
import javafx.scene.shape.Shape;
import static javafx.scene.paint.Color.rgb;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.WHITE;

public abstract class ShapeProxy extends ComponentProxy {

    protected Shape proxyObject;

    @Override
    public void fill(int red, int green, int blue, double alpha) {
        proxyObject.setFill(rgb(red, green, blue, alpha));
    }

    @Override
    public void fill(int red, int green, int blue) {
        proxyObject.setFill(rgb(red, green, blue));
    }

    @Override
    public void fillRed() {
        proxyObject.setFill(RED);
    }

    @Override
    public void fillBlue() {
        proxyObject.setFill(BLUE);
    }

    @Override
    public void fillGreen() {
        proxyObject.setFill(GREEN);
    }

    @Override
    public void fillWhite() {
        proxyObject.setFill(WHITE);
    }

    @Override
    public void setColor(ColorProvidedObject color) {
        proxyObject.setFill(color.getProxy().getProxyObject());
    }
}
