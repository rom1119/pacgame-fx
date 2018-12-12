package com.pacgame.provider.event;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.ViewProvidedObject;
import javafx.event.Event;

public interface IEventHandler<T extends EventProvidedObject> {

    IEventHandlerProxy<? super Event> getProxy();

}
