package com.pacgame.game;

import com.pacgame.game.ui.model.Menu;
import com.pacgame.game.ui.model.main.LoginForm;
import com.pacgame.game.ui.model.main.MainMenuToLogin;

import java.util.Set;

public class UILayout {

    private IScene scene;
    private Menu mainMenu;
    private ILayer root;
    private Set<IView> elements;
    private ISceneFactory sceneFactory;
    private LoginForm loginForm;

    public UILayout(ILayer root, ISceneFactory sceneFactory) {
        this.root = root;
        this.sceneFactory = sceneFactory;
    }

    public void initScene( int width, int height)
    {
        this.scene = sceneFactory.createScene(root, width, height);
    }

    public Menu createMenu(IMenuFactory menuFactory)
    {
        mainMenu = new MainMenuToLogin(menuFactory.createMenu(MainMenuToLogin.WIDTH, MainMenuToLogin.HEIGHT));
        addLoginElement(mainMenu, menuFactory.createMenuItem("Zaloguj"));
        root.addElement(mainMenu.getMenuElement());

        return mainMenu;
    }

    public void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory componentFactory)
    {
        loginForm = new LoginForm(layoutFactory, componentFactory, root);
        ILayer iLayer = loginForm.buildView();
        root.addElement(iLayer);
    }


    private void addLoginElement(Menu menu, IMenuItem menuItem)
    {
        mainMenu.addMenuItem(menuItem);
        menuItem.setOnSelect(e -> {
            mainMenu.hide();
            loginForm.show();
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
