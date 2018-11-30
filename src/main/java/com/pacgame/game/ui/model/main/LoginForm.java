package com.pacgame.game.ui.model.main;

import com.pacgame.game.*;

public class LoginForm {

    private ILayoutFactory layoutFactory;
    private IUIComponentFactory componentFactory;
    private IColorFactory colorFactory;
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

    public LoginForm(ILayoutFactory layoutFactory, IUIComponentFactory componentFactory, ILayer parent, IColorFactory colorFactory) {
        this.layoutFactory = layoutFactory;
        this.componentFactory = componentFactory;
        this.parent = parent;
        this.colorFactory = colorFactory;
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

        passwordLabel = componentFactory.createLabelText("Hasło");
        passwordInput = componentFactory.createInputText(parent.getWidth() / 4, 50);

        return passwordLayer;
    }

    private ILayer createSendButton()
    {
        sendBtnLayer = layoutFactory.createVerticalLayer(parent.getWidth() / 2,  parent.getHeight() / 2);

        sendBtn = componentFactory.createButtonSuccess("Zaloguj się");
        globalError = componentFactory.createLabelText("");

        return sendBtnLayer;
    }

    public void show() {
        root.show();
    }
}
