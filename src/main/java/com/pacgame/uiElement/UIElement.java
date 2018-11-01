package com.pacgame.uiElement;

import com.pacgame.Component;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IUIEventTarget;

public abstract class UIElement extends Component implements IUIEventTarget {
    public UIElement(int width, int height) {
        super(width, height);
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
