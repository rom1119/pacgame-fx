package com.pacgame.provider.event;

import javafx.event.Event;
import javafx.event.EventHandler;

public interface IEventHandlerProxy<T extends Event> {

      void handle(T event);
}
