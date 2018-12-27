package com.pacgame.game;

import com.pacgame.game.ui.views.MainMenu;
import com.pacgame.game.ui.views.Menu;
import com.pacgame.game.ui.views.main.LoginForm;
import com.pacgame.game.ui.views.MainMenuToLogin;

import java.util.Set;

public class UILayout {

    public static final int LEFT_SIDE_WIDTH = 500;
    public static final int LEFT_SIDE_HEIGHT = 500;

    private IColorFactory colorFactory;
    private IScene scene;
    private MainMenu mainMenu;
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

    public Menu createMenu(IMenuFactory menuFactory, IEventFacade eventFacade)
    {
        mainMenu = new MainMenuToLogin(menuFactory, eventFacade);
        mainMenu.setWidth(LEFT_SIDE_WIDTH);
        mainMenu.setHeight(LEFT_SIDE_HEIGHT);
        mainMenu.setColor(colorFactory.createCustom(0, 0, 0, 0.1));

        root.addElement(mainMenu.getMenuElement());
//        mainMenu.getMenuElement().setX(200);
//        mainMenu.hide();

        return mainMenu;
    }

    public void buildHiddenViews(ILayoutFactory layoutFactory, IUIComponentFactory uiComponentFactory) {
        mainMenu.buildHiddenViews(layoutFactory, uiComponentFactory, root );

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
