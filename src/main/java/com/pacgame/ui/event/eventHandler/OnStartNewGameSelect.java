package com.pacgame.ui.event.eventHandler;

import com.pacgame.App;
import com.pacgame.board.model.Point;
import com.pacgame.ui.component.View;
import com.pacgame.board.service.MapPathCreator;
import com.pacgame.board.service.PointPopulator;
import com.pacgame.ui.event.MenuHandler;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class OnStartNewGameSelect extends MenuHandler {

    private Group rootPane;

    public OnStartNewGameSelect(View viewToHide, View viewToShow, Group rootPane) {
        super(viewToHide, viewToShow);
        this.rootPane = rootPane;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param e the event which occurred
     */
    @Override
    public void handle(Event e) {
        KeyEvent event = (KeyEvent) e;
        if (event.getCode() != KeyCode.ENTER) {
            return;
        }

        if (getViewToHide().isVisible() && !App.isPlaying()) {
            PointPopulator.depopulate(rootPane);
            App.pacmanController.deinitialize();
            App.clearAllMazesController();

            App.indexForMaze = rootPane.getChildren().indexOf(App.entryTimer.getPane());

            App.pacmanController.initialize();
            App.pacmanController.setInitPosition();
            getViewToHide().hide();
            App.clearAllMazesController();
            App.indexForMaze = rootPane.getChildren().indexOf(App.entryTimer.getPane());

            ObservableList<Point> allPoints = PointPopulator.populate(MapPathCreator.getAllPoints(), rootPane);
            App.indexForMaze = rootPane.getChildren().indexOf(App.entryTimer.getPane());

//            App.createMazeTimeline(rootPane);
            App.pacmanController.setAllPoints(allPoints);

            App.pause();
            App.entryTimer.startEntryTimer();
            App.setRunningGame(true);
            App.setPlaying(false);

        }
    }
}
