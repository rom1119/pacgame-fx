package com.pacgame.game.adapter.board;

import com.pacgame.Layer;
import com.pacgame.game.ILayer;
import com.pacgame.game.adapter.LayerAdapter;
import com.pacgame.game.board.BoardMap;
import com.pacgame.game.board.model.level.IMapPoint;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.map.Level;
import com.pacgame.map.LevelsFacade;

public class BoardMapAdapter extends LayerAdapter implements BoardMap {

    private Level levelProvidedObject;

    public BoardMapAdapter(Level levelProvidedObject) {
        this.levelProvidedObject = levelProvidedObject;
    }

    @Override
    public void createPoints() {

    }

    @Override
    public void addPacman(IPacman pacman) {

    }

    @Override
    public IMapPoint getPacmanInitPosition() {
        return null;
    }

    @Override
    public IMapPoint getMazeInitPosition() {
        return null;
    }

    @Override
    public void addMaze(IMaze maze) {

    }

    @Override
    public ILayer getView() {
        return null;
    }

    @Override
    public Layer getProvidedObject() {
        return null;
    }
}
