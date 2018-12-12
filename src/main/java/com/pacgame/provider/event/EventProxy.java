package com.pacgame.provider.event;

import com.pacgame.provider.Proxy;
import javafx.event.Event;

import java.lang.reflect.Type;

public abstract class EventProxy extends Proxy {


    public abstract Class<? extends EventProxy> getType();

    protected abstract Event getProxyObject();
}
