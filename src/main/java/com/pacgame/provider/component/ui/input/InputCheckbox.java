package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.alignment.PositionAlignment;
import com.pacgame.provider.component.ui.UIElementProxy;

public class InputCheckbox extends UIInput {

    protected InputCheckboxProxy proxy;

    public InputCheckbox() {
        proxy = new InputCheckboxProxy();
    }

    @Override
    protected UIElementProxy getProxy() {
        return proxy;
    }

    public void setAlignment(PositionAlignment positionAlignment) {
        proxy.setAlignment(positionAlignment.getProxy());

    }
}
