package com.pacgame.event.eventHandler;

import com.pacgame.App;
import com.pacgame.controller.MazeController;
import com.pacgame.event.PointEvent;
import com.pacgame.model.Maze;
import com.pacgame.model.point.BigPoint;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class OnDestroyBigPoint implements EventHandler<PointEvent> {

    private final String blueMazeBackground = "./enemy/blue/main.png";
    private final int TIME_ACTION = 5000;
    public static final int SPEED_MULTIPLIER = 10;

    public void destroy(BigPoint bigPoint) {
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

        BigPoint bigPoint = (BigPoint) event.getPoint();
        if (bigPoint.isVisible()) {
            setBlueAllMazes(App.mazesCollection);
            this.destroy(bigPoint);
            event.getPacmanController().addScore(bigPoint.getValue());

        }
    }

    private void setBlueAllMazes(ObservableList<MazeController> mazeControllers)
    {
        for (MazeController mazeController : mazeControllers) {
            Maze maze = (Maze) mazeController.getControlledObject();
            if (maze.isGhost()) {
                continue;
            }
            changeStatesOnStartAction(mazeController);

        }
    }

    protected void changeStatesOnStartAction(MazeController mazeController)
    {
        mazeController.setMovedByAI(false);
        Maze maze = (Maze) mazeController.getControlledObject();

        maze.setIconBackground(blueMazeBackground);
        maze.setEatable(true);
        int currentSpeed = maze.getSpeedMove();
        maze.speedMoveProperty().set(currentSpeed + SPEED_MULTIPLIER);
        mazeController.getMovementManager().changeSpeedAnimationMove();
        doSomethingOnTime(mazeController);
    }

    protected void changeStatesOnEndAction()
    {
        for (MazeController mazeController : App.mazesCollection) {

            Maze maze = (Maze) mazeController.getControlledObject();
            if (maze.isEatable()) {
                mazeController.setMovedByAI(true);
                maze.setEatable(false);
                int currentSpeed = maze.getSpeedMove();
                maze.speedMoveProperty().set(currentSpeed - SPEED_MULTIPLIER);
                mazeController.getMovementManager().changeSpeedAnimationMove();
                maze.updateIcon();
            }

        }
    }


    private void doSomethingOnTime(MazeController mazeController)
    {
        KeyFrame actionsOnTime = new KeyFrame(Duration.millis(TIME_ACTION), new EventHandler() {
            @Override
            public void handle(Event event) {
            }
        });

//            KeyFrame keyFrame = new KeyFrame(Duration.millis(calculateAnimationDuration()), keyValueIconX, keyValueIconY, keyValueColliderX, keyValueColliderY);
        Timeline animation = mazeController.getStateTimeline();

        if (animation != null) {
            animation.pause();
        }

        animation = new Timeline();

        mazeController.setStateTimeline(animation);

        animation.getKeyFrames().clear();
        animation.getKeyFrames().add(actionsOnTime);
        animation.setDelay(Duration.millis(0));

        animation.setCycleCount(1);
        animation.setAutoReverse(false);
        animation.play();

        animation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (allMazesTimelineEnd()) {
                    OnDestroyBigPoint.this.changeStatesOnEndAction();
                }
            }
        });
    }

    private boolean allMazesTimelineEnd()
    {
        for (MazeController mazeController : App.mazesCollection) {

            if (mazeController.getStateTimeline().getStatus() == Timeline.Status.RUNNING) {
                return false;
            }
        }

        return true;
    }

}
