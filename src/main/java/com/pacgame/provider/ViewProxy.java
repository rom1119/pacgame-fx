package com.pacgame.provider;


import com.pacgame.provider.color.PaintProxy;
import com.pacgame.provider.event.IEventHandler;
import com.pacgame.provider.event.handler.ViewEventDispatcher;
import com.pacgame.provider.interfaces.ColorableProvidedProxy;
import com.pacgame.provider.interfaces.PositionableProvider;
import com.pacgame.provider.interfaces.VisibleProvider;
import com.pacgame.provider.property.*;
import com.pacgame.provider.scene.SceneProxy;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public abstract class ViewProxy extends Proxy implements ColorableProvidedProxy, PositionableProvider, Comparable<ViewProxy>, VisibleProvider {
    protected PaintProxy paint;

    protected PropertyProvider<Integer> x;
    protected PropertyProvider<Integer> y;
    protected int order;
    private ViewEventDispatcher eventDispatcher;


    public ViewProxy() {
        x = new TranslateXProperty(0);
        y = new TranslateYProperty(0);
    }


    @Override
    public boolean isVisible() {
        return getProxyObject().isVisible();
    }

    @Override
    public void show() {
        getProxyObject().setVisible(true);
    }

    @Override
    public void hide() {
        getProxyObject().setVisible(false);
    }

    @Override
    public int compareTo(ViewProxy o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (order == o.order) {
            return 0;
        }

        return order > o.order ? 1 : -1 ;
    }


    @Override
    public abstract Node getProxyObject();

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
        getProxyObject().setTranslateX(x);
    }

    @Override
    public void setY(int y) {
        this.y.set(y);
        getProxyObject().setTranslateY(y);
    }

    @Override
    public void setBackground(PaintProxy color) {
        this.paint = color;
    }


    public final <T extends EventProvidedObject> void addEventHandler(EventTypeProvidedObject<T> eventType, IEventHandler<? super T> eventHandler, T event)
    {

        int eventHandlerProxyId = eventType.addEventHandler(eventHandler, event);
        EventHandler eventHandlerProxy = eventType.getProxy().getEventHandlerProxy(eventHandlerProxyId);
        getProxyObject().addEventHandler(eventType.getProxy().getProxyObject(), eventHandlerProxy);

    }

    public final <T extends EventProvidedObject> void removeEventHandler(EventTypeProvidedObject<T> eventType, IEventHandler<? super T> eventHandler)
    {
        int handlerId = eventType.removeEventHandler(eventHandler);
        EventHandler eventHandlerProxy = eventType.getProxy().removeEventHandlerProxy(handlerId);
        getProxyObject().removeEventHandler(eventType.getProxy().getProxyObject(), eventHandlerProxy);
    }

    public SceneProxy getScene() {
        System.out.println(getProxyObject().getScene());
        return null;
    }

    public void setFocusTraversable(boolean val) {
        getProxyObject().setFocusTraversable(val);
    }

    public void requestFocus() {
        getProxyObject().requestFocus();
    }

//    public <T extends EventProxy> void addEventHandler(EventTypeProxy<T> eventTypeProxy, IEventHandlerProxy<? super T> eventHandler)
//    {
//        getEventDispatcher()
//                .getEventHandlerManager()
//                .addEventhandler(eventTypeProxy, eventHandler);
//    }
//
//    private ViewEventDispatcher getEventDispatcher() {
//        return eventDispatcher;
//    }
//
//    public void fireEvent(EventProxy eventProxy)
//    {
//        getProxyObject().addEventHandler(, );
//        getProxyObject().fireEvent(eventProxy.getProxyObject());
//        getProxyObject().getEventDispatcher().
//    }
}
