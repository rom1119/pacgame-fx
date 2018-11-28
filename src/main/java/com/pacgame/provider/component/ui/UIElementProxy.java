package com.pacgame.provider.component.ui;

import com.pacgame.provider.component.ComponentProxy;
import javafx.scene.control.Control;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Paint;

public abstract class UIElementProxy extends ComponentProxy {

    protected Control proxyObject;


    public void setBorder(Paint color, int width)
    {
        proxyObject.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, null, new BorderWidths(width))));
    }
}
