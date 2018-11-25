package com.pacgame.game;

import com.pacgame.game.ui.model.Menu;

import java.util.Map;
import java.util.Set;

public class UILayout {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private IScene scene;
    private Menu mainMenu;
    private ILayer root;
    private Set<IView> elements;

    public UILayout(ILayer root, ISceneFactory sceneFactory) {
        this.root = root;
        initScene(sceneFactory);
    }

    private void initScene(ISceneFactory sceneFactory)
    {
        this.scene = sceneFactory.createScene(root, WIDTH, HEIGHT);
    }

    public Menu createMenu()
    {
        mainMenu = new Menu();

        return mainMenu;
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
