package com.pacgame.uiElement;

import com.pacgame.Component;
import com.pacgame.Property;
import com.pacgame.color.Paint;
import com.pacgame.event.IEvent;
import com.pacgame.event.target.IUIEventTarget;
import com.pacgame.property.HeightProperty;
import com.pacgame.property.WidthProperty;
import com.pacgame.provider.UIProvider;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.provider.component.UIElementProvidedObject;

public abstract class UIElement extends Component implements IUIEventTarget {

    protected Property<Integer> width;
    protected Property<Integer> height;

    protected UIElementProvidedObject providedObject;

    public UIElement(UIProvider provider, int width, int height) {
        super();
        this.width = new WidthProperty(width);
        this.height = new HeightProperty(height);
    }

    public UIElement(UIProvider provider) {
        this.width = new WidthProperty(0);
        this.height = new HeightProperty(0);
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
    protected ViewProvidedObject getProvidedObject() {
        return providedObject;
    }

    public void setBorder(Paint color, int width)
    {
        providedObject.setBorder(color.getValue(), width);
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
