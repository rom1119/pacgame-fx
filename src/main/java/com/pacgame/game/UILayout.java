package com.pacgame.game;

import com.pacgame.game.ui.views.MainMenuFull;
import com.pacgame.game.ui.views.Menu;
import com.pacgame.game.ui.views.main.LoginForm;
import com.pacgame.game.ui.views.MainMenuToLogin;

import java.util.Set;

public class UILayout {

    public static final int LEFT_SIDE_WIDTH = 500;
    public static final int LEFT_SIDE_HEIGHT = 500;

    private IColorFactory colorFactory;
    private IScene scene;
    private MainMenuToLogin mainMenuBeforeLogin;
    private MainMenuFull mainMenuFull;
    private ILayer root;
    private Set<IView> elements;
    private ISceneFactory sceneFactory;
    private LoginForm loginForm;
    private IEventFacade eventFacade;

    public UILayout(ILayer root, ISceneFactory sceneFactory, IColorFactory colorFactory) {
        this.root = root;
        this.sceneFactory = sceneFactory;
        this.colorFactory = colorFactory;

    }

    public void initScene( int width, int height)
    {
        this.scene = sceneFactory.createScene(root, width, height);
    }

    public void createMenus(IMenuFactory menuFactory, IEventFacade eventFacade)
    {
        mainMenuBeforeLogin = new MainMenuToLogin(menuFactory, eventFacade);
        mainMenuBeforeLogin.setWidth(LEFT_SIDE_WIDTH);
        mainMenuBeforeLogin.setHeight(LEFT_SIDE_HEIGHT);
        mainMenuBeforeLogin.setColor(colorFactory.createCustom(0, 0, 0, 0.1));

        mainMenuBeforeLogin.hide();

        mainMenuFull = new MainMenuFull(menuFactory, eventFacade);
        mainMenuFull.setWidth(LEFT_SIDE_WIDTH);
        mainMenuFull.setHeight(LEFT_SIDE_HEIGHT);
        mainMenuFull.setColor(colorFactory.createCustom(0, 0, 0, 0.1));

        root.addElement(mainMenuBeforeLogin.getMenuElement());
        root.addElement(mainMenuFull.getMenuElement());
//        mainMenuBeforeLogin.getMenuElement().setX(200);
//        mainMenuBeforeLogin.hide();

    }

    public void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory) {
        mainMenuBeforeLogin.buildHiddenViews(layoutFactory, uiComponentFactory, root );

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
