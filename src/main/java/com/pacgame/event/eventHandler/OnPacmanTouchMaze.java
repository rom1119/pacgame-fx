package com.pacgame.event.eventHandler;

import com.pacgame.App;
import com.pacgame.event.MazeEvent;
import com.pacgame.model.Maze;
import javafx.event.EventHandler;

public class OnPacmanTouchMaze implements EventHandler<MazeEvent> {
    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(MazeEvent event) {
        Maze maze = (Maze) event.getMazeController().getControlledObject();
        if (maze.isGhost()) {
            return;
        }

        if (maze.isEatable()) {
            maze.setEatable(false);
            maze.setGhost(true);
            event.getMazeController().setMovedByAI(true);
            maze.updateIcon();
            event.getPacmanController().addScore(maze.getValue());
//            int currentSpeed = maze.getSpeedMove();
//            maze.speedMoveProperty().set(currentSpeed - 5);
        } else {
            event.getPacmanController().subtractLive();
            App.clearAllMazesController(event.getRoot());
            event.getMazeController().getPacmanController().setInitPosition();
            App.setRunning(false);
        }

    }
}
