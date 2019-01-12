package com.pacgame.game.event.board;

import com.pacgame.game.event.Event;
import com.pacgame.game.event.EventType;
import com.pacgame.game.event.Source;
import com.pacgame.game.event.Target;

public class BoardElementMove extends GameBoardEvent {

    public static final EventType<BoardElementMove> BOARD_ELEMENT_MOVE_ANY_EVENT = new EventType<>(GameBoardEvent.GAME_BOARD_ANY_EVENT, "BOARD_ELEMENT_MOVE_ANY_EVENT");

    public static final EventType<BoardElementMove> PACMAN_MOVE_EVENT = new EventType<>(BoardElementMove.BOARD_ELEMENT_MOVE_ANY_EVENT, "PACMAN_MOVE_EVENT");
    public static final EventType<BoardElementMove> MAZE_MOVE_EVENT = new EventType<>(BoardElementMove.BOARD_ELEMENT_MOVE_ANY_EVENT, "MAZE_MOVE_EVENT");

    private int x;
    private int y;


    public BoardElementMove(Source source, Target target, EventType<? extends Event> eventType, int x, int y) {
        super(source, target, eventType);
        this.x = x;
        this.y = y;
    }

    public BoardElementMove(Source source, Target target, int x, int y) {
        super(source, target);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
