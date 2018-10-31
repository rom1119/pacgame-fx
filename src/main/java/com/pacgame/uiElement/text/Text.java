package com.pacgame.uiElement.text;

import com.pacgame.event.IEvent;
import com.pacgame.uiElement.UIElement;

public abstract class Text extends UIElement {
    public Text(int width, int height) {
        super(width, height);
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
