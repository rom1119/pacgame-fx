package com.pacgame.uiElement.input;

import com.pacgame.event.IEvent;
import com.pacgame.uiElement.UIElement;

public abstract class UIInput extends UIElement {
    public UIInput(int width, int height) {
        super(width, height);
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
