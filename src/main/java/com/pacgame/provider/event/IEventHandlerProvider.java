package com.pacgame.provider.event;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import javafx.event.Event;

public interface IEventHandlerProvider<T extends EventProvidedObject> {

//    IEventHandlerProxy<? super Event> getProxy();

    void handle(T event);

}
