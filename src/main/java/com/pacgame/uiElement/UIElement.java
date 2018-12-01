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
        return getProvidedObject().isVisible();
    }

    @Override
    public void show() {
        getProvidedObject().show();
    }

    @Override
    public void hide() {
        getProvidedObject().hide();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        getProvidedObject().setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        getProvidedObject().setY(y);
    }

    @Override
    public void setBackground(Paint color) {
        getProvidedObject().setBackground(color.getValue());
    }

    @Override
    protected abstract UIElementProvidedObject getProvidedObject();

    public void setBorder(Paint color, int width)
    {
        getProvidedObject().setBorder(color.getValue(), width);
    }

    public void setPadding(int top, int bottom, int left, int right) {
        getProvidedObject().setPadding(top, bottom, left, right);
    }

    public void setPadding(int x, int y) {
        getProvidedObject().setPadding(x, y);
    }

    public void setPadding(int topRightBottomLeft){
        getProvidedObject().setPadding(topRightBottomLeft);
    }

    @Override
    public IEvent dispatchEvent(IEvent event) {
        return null;
    }
}
