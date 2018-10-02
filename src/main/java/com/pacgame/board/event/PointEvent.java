package com.pacgame.board.event;

import com.pacgame.Point;
import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventType;

public class PointEvent extends Event {

    private static EventType<PointEvent> POINT_EVENTS = new EventType<>("POINT_EVENTS");
    public static EventType<PointEvent> DESTROY = new EventType<>(POINT_EVENTS, "DESTROY");

    private PacmanController pacmanController;
    private ObservableList<MazeController> mazeControllerList;
    private Point point;

    /**
     * Construct a new {@code Event} with the specified event source, target
     * and type. If the source or target is set to {@code null}, it is replaced
     * by the {@code NULL_SOURCE_TARGET} value.
     *
     * @param eventType the event type
     */
    public PointEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

    public ObservableList<MazeController> getMazeControllerList() {
        return mazeControllerList;
    }

    public void setMazeControllerList(ObservableList<MazeController> mazeControllerList) {
        this.mazeControllerList = mazeControllerList;
    }

    public PacmanController getPacmanController() {
        return pacmanController;
    }

    public void setPacmanController(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}