package com.pacgame.game.ui.views;

import com.pacgame.game.*;
import com.pacgame.game.event.ExitGame;

public class MainMenuFull extends MainMenu {

    public MainMenuFull(IMenuFactory menuFactory, IEventFacade eventFacade) {
        super(menuFactory, eventFacade);
        addNewGame("Rozpocznij grę");
        addRegisterElement("Wczytaj grę");
        addRegisterElement("Ranking graczy");
        addRegisterElement("Twój profil");
        addRegisterElement("Ustawienia");
        addRegisterElement("Pomoc");
        addExitElement("Wyjście");
    }

    @Override
    public void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory, ILayer root)
    {
//        loginForm = new LoginForm(layoutFactory, uiComponentFactory);
//        loginForm.setMenu(this);
//        ILayer iLoginLayer = loginForm.buildView(getWidth(), getHeight());
//        iLoginLayer.hide();
//
//        registerForm = new RegisterForm(layoutFactory, uiComponentFactory);
//        registerForm.setMenu(this);
//        ILayer iRegisterLayer = registerForm.buildView(getWidth(), getHeight());
//        iRegisterLayer.hide();
//
//        root.addElement(iLoginLayer);
//        root.addElement(iRegisterLayer);
    }


    private void addNewGame(String text)
    {
        IMenuItem menuItem = addMenuItem(text);
        menuItem.setOnSelect(e -> {
            this.hide();
//            loginForm.show();
        });

    }

    private void addRegisterElement(String text)
    {
        IMenuItem menuItem = addMenuItem(text);
        menuItem.setOnSelect(e -> {
            this.hide();
//            registerForm.show();
        });

    }

    private void addExitElement(String text)
    {
        IMenuItem menuItem = addMenuItem(text);
        menuItem.setOnSelect(e -> {
            eventFacade.appEventFacade().emitEvent(eventFacade.appEventFacade().createExitGameEvent(this, menuItem, ExitGame.APP_EXIT_EVENT));
        });

    }
}
