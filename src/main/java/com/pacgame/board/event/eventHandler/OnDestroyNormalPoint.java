package com.pacgame.board.event.eventHandler;

import com.pacgame.board.event.PointEvent;
import com.pacgame.board.model.point.NormalPoint;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class OnDestroyNormalPoint implements EventHandler<PointEvent> {

    public void destroy(NormalPoint bigPoint) {
        bigPoint.getIcon().setFill(Color.TRANSPARENT);
        bigPoint.setVisible(false);
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    public void handle(PointEvent event) {

        NormalPoint bigPoint = (NormalPoint) event.getPoint();
        if (bigPoint.isVisible()) {

            this.destroy(bigPoint);
            event.getPacmanController().addScore(bigPoint.getValue());

        }
    }
}
