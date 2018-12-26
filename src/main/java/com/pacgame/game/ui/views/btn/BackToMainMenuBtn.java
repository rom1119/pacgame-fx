package com.pacgame.game.ui.views.btn;

import com.pacgame.game.*;
import com.pacgame.game.ui.views.MainMenu;
import com.pacgame.game.ui.views.Screen;

public class BackToMainMenuBtn {

    private IButton button;

    private static String text = "Powrót do menu";

    private MainMenu menuToShow;
    private Screen screen;

    private IUIComponentFactory componentFactory;


    public BackToMainMenuBtn(MainMenu menuToShow, Screen screen, IUIComponentFactory componentFactory) {
        this.menuToShow = menuToShow;
        this.screen = screen;
        this.componentFactory = componentFactory;


        createView();
    }

    private void createView()
    {
        button = componentFactory.createButton(text);
        setOnAction();

    }

    public IButton getView() {
        return button;
    }

    private void setOnAction()
    {
        button.setOnAction(e -> {
            screen.hide();
            menuToShow.show();
        });
    }
}
