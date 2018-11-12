package com.pacgame.uiElement.menu.element;

import com.pacgame.Property;
import com.pacgame.property.TextProperty;
import com.pacgame.uiElement.UIElement;
import com.pacgame.uiElement.text.Text;

public abstract class MenuElement extends UIElement {

    protected Text providedObject;
    protected Property<String> text;

    public MenuElement(int width, int height) {
        super(width, height);
        text = new TextProperty();
    }

    public void setText(String text) {
        this.text.set(text);
    }
}
