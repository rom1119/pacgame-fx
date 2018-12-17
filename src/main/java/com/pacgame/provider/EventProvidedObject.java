package com.pacgame.provider;

import com.pacgame.provider.event.EventProxy;
import com.pacgame.provider.event.IEventTarget;
import com.pacgame.provider.interfaces.IChildrenProvider;
import javafx.event.EventTarget;

import java.util.Map;

public abstract class EventProvidedObject extends ProvidedObject {

    @Override
    protected abstract EventProxy getProxy();

    protected IEventTarget target;

    protected Object source;

    protected EventType eventType;

    public EventProvidedObject(IEventTarget target, Object source, EventType eventType) {
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

    public IEventTarget getTarget() {
        return target;
    }

    public void setTarget(IEventTarget target) {
        this.target = target;
    }

    private void recursiveTarget(Map<String, ProvidedObject> children,int hashCodeProxyObject) {
        for (Map.Entry<String, ProvidedObject> el : children.entrySet() ) {

            if (providedObjectHasSameHashCode(el.getValue(), hashCodeProxyObject)) {
                setTarget((IEventTarget) el.getValue());
                return;
            }
            if (el.getValue() instanceof IChildrenProvider) {
                recursiveTarget(((IChildrenProvider) el.getValue()).getChildren(), hashCodeProxyObject);

            }
        }
        return;
    }

    private boolean providedObjectHasSameHashCode(ProvidedObject providedObject, int hashCodeAnotherProvidedObject)
    {
        return providedObject.getProxy().getProxyObject().hashCode() == hashCodeAnotherProvidedObject;
    }
//        setTarget();

    public void initTarget(int hashCodeProxyObject) {

        if (providedObjectHasSameHashCode((ProvidedObject)getSource(), hashCodeProxyObject)) {
            setTarget((IEventTarget) getSource());
            System.out.println("NOTrecurc");
        } else {
            System.out.println("recurc");
            recursiveTarget(((IChildrenProvider) getSource()).getChildren(), hashCodeProxyObject);
        }
//        if (source instanceof IChildrenProvider) {
//        }

//        setTarget((IEventTarget) getSource());
    }
}
