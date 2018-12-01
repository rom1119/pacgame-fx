package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.Paint;
import com.pacgame.provider.component.ui.UIElementProxy;

public class InputText extends UIInput {

    protected InputTextProxy proxy;

    public InputText() {
        proxy = new InputTextProxy();
    }

    @Override
    protected UIElementProxy getProxy() {
        return proxy;
    }

}
