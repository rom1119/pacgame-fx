package com.pacgame.uiElement.btn;

import com.pacgame.event.IEventHandler;
import com.pacgame.event.type.ActionEvent;
import com.pacgame.event.type.Event;
import com.pacgame.provider.UIProvider;
import com.pacgame.provider.component.UIElementProvidedObject;
import com.pacgame.provider.component.ui.button.ButtonProvidedObject;
import com.pacgame.uiElement.UIElement;

public abstract class Button extends UIElement {

    protected ButtonProvidedObject providedObject;

    public Button(UIProvider provider, String text) {
        super(provider);
    }

    @Override
    protected ButtonProvidedObject getProvidedObject() {
        return providedObject;
    }

    public final void setOnAction(IEventHandler<ActionEvent> eventHandler)
    {
        ActionEvent actionEvent = new ActionEvent();
        getProvidedObject().setOnAction(e -> {
            actionEvent.setProvidedObject(e);
            eventHandler.handle(actionEvent);
        });
    }
}
