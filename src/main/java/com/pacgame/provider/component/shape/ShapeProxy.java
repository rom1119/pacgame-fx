package com.pacgame.provider.component.shape;

import com.pacgame.provider.component.ComponentProxy;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import static javafx.scene.paint.Color.rgb;

public abstract class ShapeProxy extends ComponentProxy {

    protected Shape proxyObject;

    @Override
    public void setBackground(Paint color) {
        proxyObject.setFill(color);
    }
}
