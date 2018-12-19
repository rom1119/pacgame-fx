package com.pacgame.event.type;

import com.pacgame.EventType;
import com.pacgame.IChildren;
import com.pacgame.View;
import com.pacgame.event.IEvent;
import com.pacgame.provider.EventProvidedObject;

import java.util.Map;

public abstract class Event implements IEvent {

    protected abstract EventProvidedObject getProvidedObject();

    public abstract void setProvidedObject(EventProvidedObject eventProvidedObject);

    protected EventTarget target;

    protected Object source;

    protected EventType eventType;

    public Event(EventTarget target, Object source, EventType eventType) {
        this.target = target;
        this.source = source;
        this.eventType = eventType;
    }


    public void setSource(Object obj) {
        this.source = obj;
    }

    public Object getSource() {
        return source;
    }

    @Override
    public EventTarget getEventTarget() {
        return target;
    }

    public void setTarget(EventTarget target) {
        this.target = target;
    }

    private void recursiveFindTarget(Map<String, View> children, int hashCodeProxyObject) {
        for (Map.Entry<String, View> el : children.entrySet() ) {

            if (sourceObjectHasSameHashCode(el.getValue(), hashCodeProxyObject)) {
                setTarget(el.getValue());
                return;
            }
            if (el.getValue() instanceof IChildren) {
                recursiveFindTarget(((IChildren) el.getValue()).getChildren(), hashCodeProxyObject);

            }
        }
        return;
    }

    private boolean sourceObjectHasSameHashCode(EventSource sourceObject, int hashCodeAnotherProvidedObject)
    {
        return sourceObject.getProvidedObject().hashCode() == hashCodeAnotherProvidedObject;
    }

    public void initTarget(int hashCodeProxyObject) {

        if (sourceObjectHasSameHashCode((EventSource)getSource(), hashCodeProxyObject)) {
            setTarget((EventTarget) getSource());
        } else {
            recursiveFindTarget(((IChildren) getSource()).getChildren(), hashCodeProxyObject);
        }
//        if (source instanceof IChildrenProvider) {
//        }

//        setTarget((IEventTarget) getSource());
    }
}
