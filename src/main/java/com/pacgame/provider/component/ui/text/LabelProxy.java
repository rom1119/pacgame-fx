package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.text.TextAlignment;

class LabelProxy extends UIElementProxy {

    protected javafx.scene.control.Label proxyObject;

    public LabelProxy() {
        proxyObject = new javafx.scene.control.Label();
        proxyObject.setAlignment(Pos.CENTER);
    }

    @Override
    public javafx.scene.control.Label getProxyObject() {
        return proxyObject;
    }

    @Override
    public void setBackground(PaintProxy color) {
        getProxyObject().setBackground(new Background(new BackgroundFill(color.getProxyObject(), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public String getText() {

        return getProxyObject().getText();
    }

    public void setText(String text) {
        getProxyObject().setText(text);
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

    }
}
