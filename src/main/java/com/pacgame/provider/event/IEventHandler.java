package com.pacgame.provider.event;

import com.pacgame.provider.EventProvidedObject;
import javafx.event.Event;

public interface IEventHandler<T extends EventProvidedObject> {

    IEventHandlerProxy<? super Event> getProxyObject();

}
