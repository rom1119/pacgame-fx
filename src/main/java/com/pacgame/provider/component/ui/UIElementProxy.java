package com.pacgame.provider.component.ui;

import com.pacgame.provider.component.ComponentProxy;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Paint;

public abstract class UIElementProxy extends ComponentProxy {


    @Override
    public abstract Control getProxyObject();

    public void setBorder(Paint color, int width)
    {
        getProxyObject().setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, null, new BorderWidths(width))));
    }

    public void setPadding(int top, int bottom, int left, int right) {
        getProxyObject().setPadding(new Insets(top, bottom, left, right));
    }

    public void setPadding(int x, int y) {
        getProxyObject().setPadding(new Insets(y, x, y, x));
    }

    public void setPadding(int topRightBottomLeft){
        getProxyObject().setPadding(new Insets(topRightBottomLeft));
    }
}
