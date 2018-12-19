package com.pacgame;


import com.pacgame.color.Paint;
import com.pacgame.event.IEventHandler;
import com.pacgame.event.type.EventTarget;
import com.pacgame.property.TranslateXProperty;
import com.pacgame.property.TranslateYProperty;
import com.pacgame.provider.ViewProvidedObject;
import com.pacgame.event.type.EventSource;
import com.pacgame.event.type.Event;

public abstract class View extends EventTarget implements Positionable, Colorable, Comparable<View>, Visible {

    protected int id;

    protected Property<Integer> x;
    protected Property<Integer> y;
    protected int order;


    public View() {
        x = new TranslateXProperty(0);
        y = new TranslateYProperty(0);
    }

    public int getId() {
        return id;
    }

    public void setFocusTraversable(boolean val)
    {
        getProvidedObject().setFocusTraversable(val);
    }
    public void requestFocus()
    {
        getProvidedObject().requestFocus();
    }

    public final <T extends Event> void addEventHandler(EventType<T> eventType, IEventHandler<? super T> eventHandler)
    {
        T event = eventType.getEvent();
        event.setSource(this);
        getProvidedObject().addEventHandler(eventType.getProvidedObject(), e -> {
            event.setProvidedObject(e);
            event.initTarget(e.getTarget().hashCode());

//            event.setTarget();
            eventHandler.handle(event);
        });
    }

    @Override
    public boolean isVisible()
    {
        return getProvidedObject().isVisible();
    }

    @Override
    public void show(){
        getProvidedObject().show();
    }


    @Override
    public void hide()
    {
        getProvidedObject().show();
    }

    @Override
    public int compareTo(View o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }


    @Override
    public int getX() {
        return x.get();
    }

    @Override
    public int getY() {
        return y.get();
    }

    @Override
    public Property<Integer> XProperty() {
        return x;
    }

    @Override
    public Property<Integer> YProperty() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x.set(x);
        getProvidedObject().setX(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
        getProvidedObject().setY(y);
    }


    @Override
    public void setBackground(Paint color)
    {
        getProvidedObject().setBackground(color.getValue());
    }

    @Override
    protected abstract ViewProvidedObject getProvidedObject();
}
