package com.pacgame.game.ui.views;

import com.pacgame.event.EventFacade;
import com.pacgame.game.*;
import com.pacgame.game.ui.views.Menu;
import com.pacgame.game.ui.views.main.LoginForm;
import com.pacgame.game.ui.views.main.RegisterForm;
import javafx.application.Platform;

public class MainMenuToLogin extends MainMenu {

    private LoginForm loginForm;
    private RegisterForm registerForm;

    public MainMenuToLogin(IMenuFactory menuFactory, IEventFacade eventFacade) {
        super(menuFactory, eventFacade);
        addLoginElement("Zaloguj");
        addRegisterElement("Załóż konto");
        addExitElement("Wyjście");
    }

    @Override
    public void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory, ILayer root)
    {
        loginForm = new LoginForm(layoutFactory, uiComponentFactory);
        loginForm.setMenu(this);
        ILayer iLoginLayer = loginForm.buildView(getWidth(), getHeight());
        iLoginLayer.hide();

        registerForm = new RegisterForm(layoutFactory, uiComponentFactory);
        registerForm.setMenu(this);
        ILayer iRegisterLayer = registerForm.buildView(getWidth(), getHeight());
        iRegisterLayer.hide();

        root.addElement(iLoginLayer);
        root.addElement(iRegisterLayer);
    }


    private void addLoginElement(String text)
    {
        IMenuItem menuItem = addMenuItem(text);
        menuItem.setOnSelect(e -> {
            this.hide();
            loginForm.show();
        });

    }

    private void addRegisterElement(String text)
    {
        IMenuItem menuItem = addMenuItem(text);
        menuItem.setOnSelect(e -> {
            this.hide();
            registerForm.show();
        });

    }

    private void addExitElement(String text)
    {
        IMenuItem menuItem = addMenuItem(text);
        menuItem.setOnSelect(e -> {
            eventFacade.appEventFacade().emitEvent(eventFacade.appEventFacade().exitGame());
        });

    }

}
