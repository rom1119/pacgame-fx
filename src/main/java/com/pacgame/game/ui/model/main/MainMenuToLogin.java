package com.pacgame.game.ui.model.main;

import com.pacgame.game.IColor;
import com.pacgame.game.IMenu;
import com.pacgame.game.ui.model.Menu;

public class MainMenuToLogin extends Menu {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;

    public MainMenuToLogin(IMenu menu) {
        super(menu);
        menu.setWidth(WIDTH);
        menu.setHeight(HEIGHT);
    }


}
