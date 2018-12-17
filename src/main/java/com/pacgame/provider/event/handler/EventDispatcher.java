package com.pacgame.provider.event.handler;

import com.pacgame.provider.EventProvidedObject;

public interface EventDispatcher {

    EventProvidedObject dispatchEvent(EventProvidedObject event);
}
