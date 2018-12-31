package com.pacgame.game.adapter.board;

import com.pacgame.game.board.GameObjectFactory;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.gameElement.MovingElementFactory;

public class GameObjectFactoryAdapter implements GameObjectFactory {

    private MovingElementFactory movingElementFactory;

    public GameObjectFactoryAdapter(MovingElementFactory movingElementFactory) {
        this.movingElementFactory = movingElementFactory;
    }

    @Override
    public IPacman createPacman() {
        return new PacmanAdapter(movingElementFactory.createPacman());
    }

    @Override
    public IMaze createRandomMaze() {
        return new MazeAdapter(movingElementFactory.createRandomMaze());
    }
}
