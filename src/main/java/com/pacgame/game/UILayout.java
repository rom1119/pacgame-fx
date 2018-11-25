package com.pacgame.game;

import com.pacgame.game.ui.model.Menu;

import java.util.Map;
import java.util.Set;

public class UILayout {

    private IScene scene;
    private Menu mainMenu;
    private ILayer root;
    private Set<IView> elements;

    public UILayout(ILayer root, ISceneFactory sceneFactory) {
        this.root = root;
    }

    public void initScene(ISceneFactory sceneFactory, int width, int height)
    {
        this.scene = sceneFactory.createScene(root, width, height);
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
