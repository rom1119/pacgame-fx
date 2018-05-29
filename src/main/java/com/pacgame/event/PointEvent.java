package com.pacgame.event;

import com.pacgame.Point;
import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import com.pacgame.model.Pacman;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class PointEvent extends Event {

    private static EventType<PointEvent> OPTIONS_ALL = new EventType<>("OPTIONS_ALL");
    public static EventType<PointEvent> DESTROY = new EventType<>(OPTIONS_ALL, "DESTROY");

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

    /**
     * Construct a new {@code Event} with the specified event source, target
     * and type. If the source or target is set to {@code null}, it is replaced
     * by the {@code NULL_SOURCE_TARGET} value.
     *
     * @param source    the event source which sent the event
     * @param target    the event target to associate with the event
     * @param eventType the event type
     */
    public PointEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
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