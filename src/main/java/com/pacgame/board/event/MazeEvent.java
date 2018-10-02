package com.pacgame.board.event;

import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import javafx.event.Event;
import javafx.event.EventType;

public class MazeEvent extends Event {

    private static EventType<MazeEvent> MAZE_EVENTS = new EventType<>("MAZE_EVENTS");
    public static EventType<MazeEvent> TOUCH = new EventType<>(MAZE_EVENTS, "TOUCH");

    private MazeController mazeController;
    private PacmanController pacmanController;
    private javafx.scene.Group root;

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

    public javafx.scene.Group getRoot() {
        return root;
    }

    public void setRoot(javafx.scene.Group root) {
        this.root = root;
    }
}
