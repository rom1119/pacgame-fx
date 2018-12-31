package com.pacgame.game.adapter.board;

import com.pacgame.Layer;
import com.pacgame.game.ILayer;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.board.BoardMap;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.gameElement.MovingElementFactory;
import com.pacgame.map.Level;
import com.pacgame.map.LevelsFacade;
import com.pacgame.map.point.MapPoint;

public class BoardMapAdapter extends LayerAdapter implements BoardMap {

    private Level levelProvidedObject;
    private MovingElementFactory movingElementFactory;

    public BoardMapAdapter(Level levelProvidedObject, MovingElementFactory movingElementFactory) {
        this.levelProvidedObject = levelProvidedObject;
        this.movingElementFactory = movingElementFactory;
    }

    @Override
    public void createPoints() {
        levelProvidedObject.populatePoints();

    }

    @Override
    public void addPacman(IPacman pacman) {
        levelProvidedObject.getRootLayer().addChildren(((PacmanAdapter) pacman).getProvidedObject());
    }

    @Override
    public IMapPoint getPacmanInitPosition() {
        MapPoint point = levelProvidedObject.getAllMapPoints().get("h5A");
        return new MapPointAdapter(point.getX(), point.getY());
    }

    @Override
    public IMapPoint getMazeInitPosition() {
        MapPoint point = levelProvidedObject.getAllMapPoints().get("e5");
        return new MapPointAdapter(point.getX(), point.getY());
    }

    @Override
    public void addMaze(IMaze maze) {
        levelProvidedObject.getRootLayer().addChildren(((MazeAdapter) maze).getProvidedObject());

    }

    @Override
    public ILayer getView() {
        return null;
    }

    @Override
    public Layer getProvidedObject() {
        return levelProvidedObject.getRootLayer();
    }
}
