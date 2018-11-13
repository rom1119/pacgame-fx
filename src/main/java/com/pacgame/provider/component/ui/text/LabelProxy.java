package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.color.Color;
import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.scene.control.Label;

class LabelProxy extends UIElementProxy {

    protected Label proxyObject;

    @Override
    public void fill(int red, int green, int blue, double alpha) {

    }

    @Override
    public void fill(int red, int green, int blue) {

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

    public String getText() {

        return proxyObject.getText();
    }

    public void setText(String text) {
        this.proxyObject.setText(text);
    }
}
