package com.pacgame.provider.component.ui.text;

import com.pacgame.provider.Paint;
import com.pacgame.provider.alignment.PositionAlignment;
import com.pacgame.provider.component.UIElementProvidedObject;

public class Label extends UIElementProvidedObject {

    protected LabelProxy proxy;
    protected String text;

    public Label(String text) {
        this.text = text;
        proxy = new LabelProxy();
        proxy.setText(text);
    }

    public void setAlignment(PositionAlignment positionAlignment) {
        proxy.setAlignment(positionAlignment.getProxy());

    }

    public void setText(String text) {
        this.text = text;
        proxy.setText(text);
    }

    public String getText() {
        return text;
    }

    @Override
    public void setBorder(Paint paint, int width) {
        proxy.setBorder(paint.getProxy(), width);
    }

    @Override
    protected LabelProxy getProxy() {
        return proxy;
    }
}
