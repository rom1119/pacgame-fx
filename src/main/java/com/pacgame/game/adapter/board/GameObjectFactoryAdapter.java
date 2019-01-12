package com.pacgame.game.adapter.board;

import com.pacgame.event.EventFacade;
import com.pacgame.game.adapter.board.movement.MovementFactory;
import com.pacgame.game.board.GameObjectFactory;
import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.gameElement.MovingElementFactory;

public class GameObjectFactoryAdapter implements GameObjectFactory {

    private MovingElementFactory movingElementFactory;
    private EventFacade eventFacade;

    public GameObjectFactoryAdapter(MovingElementFactory movingElementFactory, EventFacade eventFacade) {
        this.movingElementFactory = movingElementFactory;
        this.eventFacade = eventFacade;
    }

    @Override
    public IPacman createPacman() {
        return new PacmanAdapter(movingElementFactory.createPacman(), eventFacade);
    }

    @Override
    public IMaze createRandomMaze() {
        return new MazeAdapter(movingElementFactory.createRandomMaze(), eventFacade);
    }
}
