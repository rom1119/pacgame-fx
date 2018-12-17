package com.pacgame.uiElement.menu;

import com.pacgame.provider.*;
import com.pacgame.provider.event.IEventHandler;
import com.pacgame.provider.event.type.MouseEvent;
import com.pacgame.provider.layer.VerticalLayer;

public class MainMenu extends Menu {

    protected VerticalLayer providedObject;

    public MainMenu(LayerProvider provider, PositionAlignmentProvider positionAlignmentProvider, EventProvider eventProvider, int width, int height) {
        super(provider, positionAlignmentProvider, eventProvider, width, height);
        providedObject = provider.createVerticalLayer();
        providedObject.setWidth(width);
        providedObject.setHeight(height);
        providedObject.setAlignment(positionAlignmentProvider.topCenter());
        providedObject.setFocusTraversable(true);

        getProvidedObject().addEventHandler(eventProvider.mouseEventFacade().click(), new IEventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                System.out.println(e.getTarget());
                System.out.println(e.getSource());
            }
        });

        getProvidedObject().addEventHandler(eventProvider.keyEventFacade().keyPressed(), e -> {
            System.out.println("{key");
        });

    }

    @Override
    protected LayerProvidedObject getProvidedObject() {
        return providedObject;
    }
}
