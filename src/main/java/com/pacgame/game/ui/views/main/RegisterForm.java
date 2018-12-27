package com.pacgame.game.ui.views.main;

import com.pacgame.game.ILayer;
import com.pacgame.game.ILayoutFactory;
import com.pacgame.game.IUIComponent;
import com.pacgame.game.IUIComponentFactory;
import com.pacgame.game.ui.views.MainMenu;
import com.pacgame.game.ui.views.Screen;
import com.pacgame.game.ui.views.btn.BackToMainMenuBtn;

public class RegisterForm implements Screen {

    private ILayoutFactory layoutFactory;
    private IUIComponentFactory componentFactory;
    private ILayer root;

    private ILayer loginLayer;
    private ILayer passwordLayer;
    private ILayer passwordConfLayer;
    private ILayer sendBtnLayer;

    // login
    private IUIComponent loginLabel;
    private IUIComponent loginInput;

    // password
    private IUIComponent passwordLabel;
    private IUIComponent passwordInput;

    // password confirm
    private IUIComponent passwordConfLabel;
    private IUIComponent passwordConfInput;

    // sendButton
    private IUIComponent sendBtn;
    private IUIComponent globalError;
    private MainMenu menu;

    public RegisterForm(ILayoutFactory layoutFactory, IUIComponentFactory componentFactory) {
        this.layoutFactory = layoutFactory;
        this.componentFactory = componentFactory;

    }

    public ILayer buildView(int width, int height)
    {
        if (root == null) {
            root = layoutFactory.createVerticalLayer(width, height);

            root.addElement(createLogin(width, height));
            root.addElement(createPassword(width, height));
            root.addElement(createPasswordConf(width, height));
//            layoutFactory.createCenteredVerticalLayer(, )
            ILayer buttonsLayer = layoutFactory.createFlowLayer(width, height);
            root.addElement(buttonsLayer);
            buttonsLayer.addElement(createBackToMenuButton(width / 2, height));
            buttonsLayer.addElement(createSendButton(width / 2, height));
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

    private ILayer createPasswordConf(int width, int height)
    {
        passwordConfLayer = layoutFactory.createCenteredVerticalLayer(width,  height / 4);

        passwordConfLabel = componentFactory.createLabelText("Potwierdź Hasło");
        passwordConfInput = componentFactory.createInputText(width / 2, 60);

        passwordConfLayer.addElement(passwordConfLabel);
        passwordConfLayer.addElement(passwordConfInput);

        return passwordConfLayer;
    }

    private ILayer createSendButton(int width, int height)
    {
        sendBtnLayer = layoutFactory.createRightedVerticalLayer(width,  height / 2);

        sendBtn = componentFactory.createButton("Załóż konto");
        globalError = componentFactory.createLabelText("");

        sendBtnLayer.addElement(sendBtn);
        sendBtnLayer.addElement(globalError);

        return sendBtnLayer;
    }

    private ILayer createBackToMenuButton(int width, int height)
    {
        sendBtnLayer = layoutFactory.createLeftedVerticalLayer(width,  height / 2);

        BackToMainMenuBtn backToMainMenuBtn = new BackToMainMenuBtn(menu, this, componentFactory);

        sendBtnLayer.addElement(backToMainMenuBtn.getView());


        return sendBtnLayer;
    }

    @Override
    public void show() {
        root.show();
    }

    @Override
    public void hide() {
        root.hide();
    }

    @Override
    public void setMenu(MainMenu mainMenu) {
        this.menu = mainMenu;
    }
}
