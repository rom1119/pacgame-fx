package com.pacgame.provider;

import com.pacgame.provider.event.IEventHandler;
import com.pacgame.provider.interfaces.ColorableProvider;
import com.pacgame.provider.interfaces.PositionableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.property.*;

public abstract class ViewProvidedObject extends ProvidedObject implements PositionableProvider, ColorableProvider, Comparable<ViewProvidedObject>, VisibleProvider {

    protected PropertyProvider<Integer> x;
    protected PropertyProvider<Integer> y;
    protected int order;


    public ViewProvidedObject() {
        x = new TranslateXProperty(0);
        y = new TranslateYProperty(0);
    }

    public <T extends EventProvidedObject> void addEventHandler(
            EventType<T> eventType,
            IEventHandler<T> eventHandler
            )
    {
        getProxy().addEventHandler(eventType.getProxy(), eventHandler);
    }


    @Override
    public abstract boolean isVisible();

    @Override
    public abstract void show();

    @Override
    public abstract void hide();

    @Override
    public int compareTo(ViewProvidedObject o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }

    @Override
    protected abstract ViewProxy getProxy();

    @Override
    public int getX() {
        return x.get();
    }

    @Override
    public int getY() {
        return y.get();
    }

    @Override
    public PropertyProvider<Integer> XProperty() {
        return x;
    }

    @Override
    public PropertyProvider<Integer> YProperty() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x.set(x);
        getProxy().setX(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
        getProxy().setY(y);
    }

    @Override
    public abstract void setBackground(Paint paint);


}
