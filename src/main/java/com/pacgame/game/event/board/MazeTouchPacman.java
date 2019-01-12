package com.pacgame.game.event.board;

import com.pacgame.game.board.model.maze.IMaze;
import com.pacgame.game.board.model.pacman.IPacman;
import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class MazeTouchPacman extends GameBoardEvent {

    public static final EventType<MazeTouchPacman> MAZE_TOUCH_PACMAN_ANY_EVENT = new EventType<>(GameBoardEvent.GAME_BOARD_ANY_EVENT, "MAZE_TOUCH_PACMAN_ANY_EVENT");


    public MazeTouchPacman(Source source, Target target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }

    public MazeTouchPacman(Source source, Target target) {
        super(source, target);
    }

    public IMaze getMaze()
    {
        return null;
    }

    public IPacman getPacman()
    {
        return null;
    }
}
