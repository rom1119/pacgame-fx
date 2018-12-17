package com.pacgame.game;

import com.pacgame.game.ui.model.Menu;
import com.pacgame.game.ui.model.main.LoginForm;
import com.pacgame.game.ui.model.main.MainMenuToLogin;

import java.util.Set;

public class UILayout {

    public static final int LEFT_SIDE_WIDTH = 500;
    public static final int LEFT_SIDE_HEIGHT = 500;

    private IColorFactory colorFactory;
    private IScene scene;
    private Menu mainMenu;
    private ILayer root;
    private Set<IView> elements;
    private ISceneFactory sceneFactory;
    private LoginForm loginForm;

    public UILayout(ILayer root, ISceneFactory sceneFactory, IColorFactory colorFactory) {
        this.root = root;
        this.sceneFactory = sceneFactory;
        this.colorFactory = colorFactory;

    }

    public void initScene( int width, int height)
    {
        this.scene = sceneFactory.createScene(root, width, height);
    }

    public Menu createMenu(IMenuFactory menuFactory)
    {
        mainMenu = new MainMenuToLogin(menuFactory.createMenu(LEFT_SIDE_WIDTH, LEFT_SIDE_HEIGHT));
        mainMenu.setColor(colorFactory.createCustom(0, 0, 0, 0.1));
        addLoginElement(mainMenu, menuFactory.createMenuItem("Zaloguj"));
        addLoginElement(mainMenu, menuFactory.createMenuItem("Załóż konto"));
        addLoginElement(mainMenu, menuFactory.createMenuItem("Wyjście"));
        root.addElement(mainMenu.getMenuElement());
//        mainMenu.getMenuElement().setX(200);
//        mainMenu.hide();

        return mainMenu;
    }

    public void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory)
    {
        loginForm = new LoginForm(layoutFactory, uiComponentFactory, root, colorFactory);
        ILayer iLayer = loginForm.buildView(LEFT_SIDE_WIDTH, LEFT_SIDE_HEIGHT);
//        root.setBackground(colorFactory.createGreen());
//        iLayer.setBackground(colorFactory.createRed());
//        root.addElement(iLayer);
    }


    private void addLoginElement(Menu menu, IMenuItem menuItem)
    {
        menu.addMenuItem(menuItem);
        menuItem.setOnSelect(e -> {
            menu.hide();
            loginForm.show();
        });

    }

    private void addRegisterElement(Menu menu, IMenuItem menuItem)
    {
        menu.addMenuItem(menuItem);
        menuItem.setOnSelect(e -> {
            menu.hide();
        });

    }private void addExitElement(Menu menu, IMenuItem menuItem)
    {
        menu.addMenuItem(menuItem);
        menuItem.setOnSelect(e -> {
            menu.hide();
        });

    }
//    @Override
//    public void addElement(IView view) {
//        elements.add(view);
//    }
//
//    @Override
//    public void removeElement(IView view) {
//        elements.remove(view);
//    }


    public IScene getScene() {
        return scene;
    }
}
