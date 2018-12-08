package com.pacgame.uiElement.text;

import com.pacgame.Property;
import com.pacgame.View;
import com.pacgame.color.Paint;
import com.pacgame.provider.UIProvider;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.ui.text.Label;
import com.pacgame.provider.component.ui.text.LabelBuilder;
import com.pacgame.uiElement.UIElement;

public abstract class Text extends UIElement {

    protected com.pacgame.provider.component.ui.text.Label providedObject;

    public Text(UIProvider provider, String text) {
        super(provider);
        this.providedObject = provider.createTextElement(text);
    }

    public String getText()
    {
        return providedObject.getText();
    }

    @Override
    public void setBorder(Paint color, int width) {
        providedObject.setBorder(color.getValue(), width);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public boolean isVisible() {
        return providedObject.isVisible();
    }

    @Override
    public void show() {
        providedObject.show();
    }

    @Override
    public void hide() {
        providedObject.hide();
    }

    @Override
    public int compareTo(View o) {
        return super.compareTo(o);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public Property<Integer> XProperty() {
        return super.XProperty();
    }

    @Override
    public Property<Integer> YProperty() {
        return super.YProperty();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        providedObject.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        providedObject.setY(y);
    }

    @Override
    public void setBackground(Paint color) {
        providedObject.setBackground(color.getValue());
    }

    @Override
    protected Label getProvidedObject() {
        return providedObject;
    }
}
