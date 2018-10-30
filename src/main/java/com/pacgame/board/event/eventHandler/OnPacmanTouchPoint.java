package com.pacgame.board.event.eventHandler;

import com.pacgame.board.controller.PacmanController;
import com.pacgame.board.event.PointEvent;
import com.pacgame.board.model.Point;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Shape;

public class OnPacmanTouchPoint implements ChangeListener<Number> {

    private PacmanController pacmanController;

    public OnPacmanTouchPoint(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }

    /**
     * This method needs to be provided by an implementation of
     * {@code ChangeListener}. It is called if the value of an
     * {@link ObservableValue} changes.
     * <p>
     * In general is is considered bad practice to modify the observed value in
     * this method.
     *
     * @param observable The {@code ObservableValue} which value changed
     * @param oldValue   The old value
     * @param newValue
     */
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        for (Point point : pacmanController.getAllPoints()) {
            Shape intersect = Shape.intersect(pacmanController.getControlledObject().getCollider(), point.getCollider());
            if (intersect.getBoundsInLocal().getWidth() >= 5 && intersect.getBoundsInLocal().getHeight() >= 5) {

                PointEvent pointEvent = new PointEvent(PointEvent.DESTROY);
                pointEvent.setPoint(point);
                pointEvent.setPacmanController(pacmanController);
                pointEvent.setMazeControllerList(pacmanController.getMazeControllerList());
                point.getCollider().fireEvent(pointEvent);


            }
        }
    }
}
