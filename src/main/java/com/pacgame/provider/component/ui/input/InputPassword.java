package com.pacgame.provider.component.ui.input;

import com.pacgame.provider.component.ui.UIElementProxy;

public class InputPassword extends UIInput {

    protected InputPasswordProxy proxy;

    public InputPassword() {
        proxy= new InputPasswordProxy();
    }

    @Override
    protected UIElementProxy getProxy() {
        return proxy;
    }
}
