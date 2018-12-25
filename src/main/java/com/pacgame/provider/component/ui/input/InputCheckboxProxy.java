package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.alignment.PositionAlignmentProxy;
import com.pacgame.provider.component.ui.UIElementProxy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;

public class InputCheckboxProxy extends UIElementProxy {

    protected CheckBox proxyObject;

    public InputCheckboxProxy() {
        proxyObject = new CheckBox();
        proxyObject.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    public void setAlignment(PositionAlignmentProxy positionProxy) {
        proxyObject.setAlignment(positionProxy.getProxyObject());

    }

    @Override
    public Control getProxyObject() {
        return proxyObject;
    }
}
