package com.pacgame.provider.event.handler;

import com.pacgame.provider.EventProvidedObject;

public class ViewEventDispatcher implements EventDispatcher {

    private final EventHandlerManager eventHandlerManager;

    public ViewEventDispatcher(EventHandlerManager eventHandlerManager) {
        this.eventHandlerManager = eventHandlerManager;
    }

    public EventHandlerManager getEventHandlerManager() {
        return eventHandlerManager;
    }

    @Override
    public EventProvidedObject dispatchEvent(EventProvidedObject event) {
        return null;
    }
}
