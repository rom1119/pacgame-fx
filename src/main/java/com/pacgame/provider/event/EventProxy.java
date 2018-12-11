package com.pacgame.provider.event;

import com.pacgame.provider.Proxy;
import javafx.event.Event;

public abstract class EventProxy extends Proxy {


    protected abstract Event getProxyObject();
}
