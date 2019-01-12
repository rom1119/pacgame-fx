package com.pacgame.game;

import com.pacgame.game.adapter.board.GameObjectFactoryAdapter;
import com.pacgame.game.board.Board;
import com.pacgame.game.board.BoardMapCreator;

public class GamePlayLayout {

    public static final int LEFT_SIDE_WIDTH = 500;
    public static final int LEFT_SIDE_HEIGHT = 500;
    private IScene scene;
    private ILayer root;
    private ISceneFactory sceneFactory;
    private Board board;
    private IEventFacade eventFacade;


    public GamePlayLayout(ILayer root, ISceneFactory sceneFactory) {
        this.root = root;
        this.sceneFactory = sceneFactory;
    }

    public void createScene(int width, int height)
    {
        this.scene = sceneFactory.createScene(root, width, height);
    }

    public IScene getScene() {

        return scene;
    }

    public void createMap(BoardMapCreator mapCreator)
    {
        board = new Board(mapCreator.createMap(root, LEFT_SIDE_WIDTH, LEFT_SIDE_HEIGHT));
        board.setEventFacade(eventFacade.boardEventFacade());
//        root.addElement(board.getView());
    }

    public void initGameObjects(GameObjectFactoryAdapter gameObjectFactoryAdapter) {
        board.initBoard(gameObjectFactoryAdapter);
    }

    public void setEventFacade(IEventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }
}
