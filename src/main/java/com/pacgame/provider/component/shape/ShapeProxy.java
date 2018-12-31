package com.pacgame.provider.component.shape;

import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.component.ComponentProxy;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import static javafx.scene.paint.Color.rgb;

public abstract class ShapeProxy extends ComponentProxy {

    @Override
    public abstract Shape getProxyObject();

    @Override
    public void setBackground(PaintProxy color) {

        getProxyObject().setFill(color.getProxyObject());
    }

    public void setRotate(int val)
    {
        getProxyObject().setRotate(val);
    }

    public int getRotate()
    {
        return (int) getProxyObject().getRotate();
    }
}
