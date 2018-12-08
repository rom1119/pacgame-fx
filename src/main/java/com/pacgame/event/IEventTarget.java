package com.pacgame.event;

public interface IEventTarget {

    IEvent dispatchEvent(IEvent event);

}
