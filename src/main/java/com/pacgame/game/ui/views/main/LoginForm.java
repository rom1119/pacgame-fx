package com.pacgame.game.ui.views.main;

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

    public ILayer buildView(int width, int height)
    {
        if (root == null) {
            root = layoutFactory.createVerticalLayer(width, height);

            root.addElement(createLogin(width, height));
            root.addElement(createPassword(width, height));
//            layoutFactory.createCenteredVerticalLayer(, )
            ILayer flowLayer = layoutFactory.createFlowLayer(width, height);
            root.addElement(flowLayer);
            flowLayer.addElement(createBackToMenuButton(width / 2, height));
            flowLayer.addElement(createSendButton(width / 2, height));
        }

        return root;
    }




    private ILayer createLogin(int width, int height)
    {
        loginLayer = layoutFactory.createCenteredVerticalLayer(width, height / 4);

        loginLabel = componentFactory.createLabelText("Login");
        loginInput = componentFactory.createInputText(width / 2, 60);
//        loginInput.setBackground(colorFactory.createCustom(255, 0, 0, 0.1));

        loginLayer.addElement(loginLabel);
        loginLayer.addElement(loginInput);

        return loginLayer;
    }

    private ILayer createPassword(int width, int height)
    {
        passwordLayer = layoutFactory.createCenteredVerticalLayer(width,  height / 4);

        passwordLabel = componentFactory.createLabelText("Hasło");
        passwordInput = componentFactory.createInputText(width / 2, 60);

        passwordLayer.addElement(passwordLabel);
        passwordLayer.addElement(passwordInput);

        return passwordLayer;
    }

    private ILayer createSendButton(int width, int height)
    {
        sendBtnLayer = layoutFactory.createRightedVerticalLayer(width,  height / 2);

        sendBtn = componentFactory.createButton("Zaloguj się");
        globalError = componentFactory.createLabelText("");

        sendBtnLayer.addElement(sendBtn);
        sendBtnLayer.addElement(globalError);

        return sendBtnLayer;
    }

    private ILayer createBackToMenuButton(int width, int height)
    {
        sendBtnLayer = layoutFactory.createLeftedVerticalLayer(width,  height / 2);
        sendBtn = componentFactory.createButton("Powrót do menu");
        globalError = componentFactory.createLabelText("");

        sendBtnLayer.addElement(sendBtn);

        return sendBtnLayer;
    }

    public void show() {
        root.show();
    }
}
