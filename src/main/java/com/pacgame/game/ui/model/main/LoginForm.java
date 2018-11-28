package com.pacgame.game.ui.model.main;

import com.pacgame.game.ILayer;
import com.pacgame.game.ILayoutFactory;
import com.pacgame.game.IUIComponent;
import com.pacgame.game.IUIComponentFactory;

public class LoginForm {

    private ILayoutFactory layoutFactory;
    private IUIComponentFactory componentFactory;
    private ILayer root;
    private ILayer parent;

    private ILayer loginLayer;
    private ILayer passwordLayer;
    private ILayer sendBtnLayer;

    // login
    private IUIComponent loginLabel;
    private IUIComponent loginInput;

    // password
    private IUIComponent passwordLabel;
    private IUIComponent passwordInput;

    // sendButton
    private IUIComponent sendBtn;
    private IUIComponent globalError;

    public LoginForm(ILayoutFactory layoutFactory, IUIComponentFactory componentFactory, ILayer parent) {
        this.layoutFactory = layoutFactory;
        this.componentFactory = componentFactory;
        this.parent = parent;
    }

    public ILayer buildView()
    {
        if (root != null) {
            return root;
        }
        root = layoutFactory.createVerticalLayer(parent.getWidth(), parent.getHeight());

        root.addElement(createLogin());
        root.addElement(createPassword());
        root.addElement(createSendButton());

        return root;
    }

    private ILayer createLogin()
    {
        loginLayer = layoutFactory.createVerticalLayer(parent.getWidth() / 2,  parent.getHeight() / 2);

        loginLabel = componentFactory.createLabelText("Login");
        loginInput = componentFactory.createInputText(parent.getWidth() / 4, 50);

        return loginLayer;
    }

    private ILayer createPassword()
    {
        passwordLayer = layoutFactory.createVerticalLayer(parent.getWidth() / 2,  parent.getHeight() / 2);

        passwordLabel = componentFactory.createLabelText("Login");
        passwordInput = componentFactory.createInputText(parent.getWidth() / 4, 50);

        return loginLayer;
    }

    private ILayer createSendButton()
    {
        sendBtnLayer = layoutFactory.createVerticalLayer(parent.getWidth() / 2,  parent.getHeight() / 2);

//        sendBtn = componentFactory.createButton(, "Zaloguj się");
        globalError = componentFactory.createLabelText("");

        return loginLayer;
    }

    public void show() {
        root.show();
    }
}
