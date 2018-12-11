package com.pacgame.provider.event;

import com.pacgame.event.IEvent;

public interface IEventTarget {

    IEvent dispatchEvent(IEvent event);

}
