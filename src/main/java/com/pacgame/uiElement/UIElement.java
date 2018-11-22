package com.pacgame.uiElement;

import com.pacgame.Component;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IUIEventTarget;
import com.pacgame.provider.UIProvider;

public abstract class UIElement extends Component implements IUIEventTarget {
    public UIElement(UIProvider provider, int width, int height) {
        super(width, height);
    }

    public UIElement(UIProvider provider) {
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
