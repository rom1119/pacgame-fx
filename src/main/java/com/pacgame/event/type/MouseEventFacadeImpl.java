package com.pacgame.event.type;

import com.pacgame.EventType;

public class MouseEventFacadeImpl implements MouseEventFacade {

    private com.pacgame.provider.event.type.MouseEventFacade mouseEventFacade;

    public MouseEventFacadeImpl(com.pacgame.provider.event.type.MouseEventFacade mouseEventFacade) {
        this.mouseEventFacade = mouseEventFacade;
        MouseEvent.ANY = new EventType<MouseEvent>(null , "KEY", MouseEvent.class , mouseEventFacade.any());
        MouseEvent.MOUSE_CLICKED = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_CLICKED", MouseEvent.class , mouseEventFacade.click());
        MouseEvent.MOUSE_ENTERED = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_ENTERED", MouseEvent.class , mouseEventFacade.enter());
        MouseEvent.MOUSE_ENTERED_TARGET = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_ENTERED_TARGET", MouseEvent.class , mouseEventFacade.enterTarget());
        MouseEvent.MOUSE_EXITED_TARGET = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_EXITED_TARGET", MouseEvent.class , mouseEventFacade.exitTarget());
        MouseEvent.MOUSE_MOVED = new EventType<MouseEvent>(MouseEvent.ANY , "MOUSE_MOVED", MouseEvent.class , mouseEventFacade.move());

    }

    @Override
    public MouseEvent newEvent(EventTarget target, EventSource source, EventType<MouseEvent> eventType) {
        return null;
    }

    @Override
    public EventType<MouseEvent> onMove() {
        return MouseEvent.MOUSE_MOVED;
    }

    @Override
    public EventType<MouseEvent> onClick() {
        return MouseEvent.MOUSE_CLICKED;
    }

    @Override
    public EventType<MouseEvent> onEnter() {
        return MouseEvent.MOUSE_ENTERED;
    }

    @Override
    public EventType<MouseEvent> onEnterTarget() {
        return MouseEvent.MOUSE_ENTERED_TARGET;
    }

    @Override
    public EventType<MouseEvent> onExitTarget() {
        return MouseEvent.MOUSE_EXITED_TARGET;
    }
}
