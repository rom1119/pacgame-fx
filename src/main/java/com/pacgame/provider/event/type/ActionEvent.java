package com.pacgame.provider.event.type;

import com.pacgame.provider.EventProvidedObject;
import com.pacgame.provider.EventTargetProvidedObject;
import com.pacgame.provider.EventTypeProvidedObject;
import com.pacgame.provider.event.EventProxy;

public class ActionEvent extends EventProvidedObject {

    protected ActionEventProxy proxy;

    private static final EventTypeProvidedObject ACTION = new EventTypeProvidedObject(null , "ANY_ACTION", ActionEvent.class );
    public static final EventTypeProvidedObject ANY_ACTION = ACTION;


    public ActionEvent(EventTargetProvidedObject target, Object source) {
        super(target, source, ANY_ACTION);
        proxy = new ActionEventProxy();
    }

    @Override
    protected ActionEventProxy getProxy() {
        return proxy;
    }
}
