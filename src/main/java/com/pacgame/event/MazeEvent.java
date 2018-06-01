package com.pacgame.event;

import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import javafx.event.Event;
import javafx.event.EventType;

public class MazeEvent extends Event {

    private static EventType<MazeEvent> MAZE_EVENTS = new EventType<>("MAZE_EVENTS");
    public static EventType<MazeEvent> TOUCH = new EventType<>(MAZE_EVENTS, "TOUCH");

    private MazeController mazeController;
    private PacmanController pacmanController;

    /**
     * Construct a new {@code Event} with the specified event type. The source
     * and target of the event is set to {@code NULL_SOURCE_TARGET}.
     *
     * @param eventType the event type
     */
    public MazeEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public MazeController getMazeController() {
        return mazeController;
    }

    public void setMazeController(MazeController mazeController) {
        this.mazeController = mazeController;
    }

    public PacmanController getPacmanController() {
        return pacmanController;
    }

    public void setPacmanController(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }
}
