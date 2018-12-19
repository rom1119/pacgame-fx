package com.pacgame.provider;

import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.interfaces.IChildrenProvider;

import java.util.Map;

public abstract class EventProvidedObject extends ProvidedObject {

    @Override
    protected abstract EventProxy getProxy();

    protected EventTargetProvidedObject target;

    protected Object source;

    protected EventTypeProvidedObject eventType;

    public EventProvidedObject(EventTargetProvidedObject target, Object source, EventTypeProvidedObject eventType) {
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

    public EventTargetProvidedObject getTarget() {
        return target;
    }

    public void setTarget(EventTargetProvidedObject target) {
        this.target = target;
    }

    private void recursiveFindTarget(Map<String, ProvidedObject> children, int hashCodeProxyObject) {
        for (Map.Entry<String, ProvidedObject> el : children.entrySet() ) {

            if (providedObjectHasSameHashCode(el.getValue(), hashCodeProxyObject)) {
                setTarget((EventTargetProvidedObject) el.getValue());
                return;
            }
            if (el.getValue() instanceof IChildrenProvider) {
                recursiveFindTarget(((IChildrenProvider) el.getValue()).getChildren(), hashCodeProxyObject);

            }
        }
        return;
    }

    private boolean providedObjectHasSameHashCode(ProvidedObject providedObject, int hashCodeAnotherProvidedObject)
    {
        return providedObject.getProxy().getProxyObject().hashCode() == hashCodeAnotherProvidedObject;
    }

    public void initTarget(int hashCodeProxyObject) {

        if (providedObjectHasSameHashCode((ProvidedObject)getSource(), hashCodeProxyObject)) {
            setTarget((EventTargetProvidedObject) getSource());
        } else {
            recursiveFindTarget(((IChildrenProvider) getSource()).getChildren(), hashCodeProxyObject);
        }
//        if (source instanceof IChildrenProvider) {
//        }

//        setTarget((IEventTarget) getSource());
    }
}
