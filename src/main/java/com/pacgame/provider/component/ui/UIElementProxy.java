package com.pacgame.provider.component.ui;

import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.component.ComponentProxy;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.*;

public abstract class UIElementProxy extends ComponentProxy {


    @Override
    public abstract Control getProxyObject();

    public void setBorder(PaintProxy color, int width)
    {
        getProxyObject().setBorder(new Border(new BorderStroke(color.getProxyObject(), BorderStrokeStyle.SOLID, null, new BorderWidths(width))));
    }

    @Override
    public void setBackground(PaintProxy color) {
        super.setBackground(color);
        getProxyObject().setBackground(new Background(new BackgroundFill(color.getProxyObject(), CornerRadii.EMPTY, Insets.EMPTY)));
    }


    public void setPadding(int top, int bottom, int left, int right) {
        getProxyObject().setPadding(new Insets(top, bottom, left, right));
    }

    public void setWidth(int width)
    {
        getProxyObject().setMaxWidth(width);
    }

    public void setHeight(int height)
    {
        getProxyObject().setMaxHeight(height);
    }

    public int getWidth()
    {
        return (int) getProxyObject().getMaxWidth();
    }

    public int getHeight()
    {
        return (int) getProxyObject().getMaxHeight();
    }


    public void setPadding(int x, int y) {
        getProxyObject().setPadding(new Insets(y, x, y, x));
    }

    public void setPadding(int topRightBottomLeft){
        getProxyObject().setPadding(new Insets(topRightBottomLeft));
    }
}
