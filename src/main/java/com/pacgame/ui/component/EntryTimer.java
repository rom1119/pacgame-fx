package com.pacgame.ui.component;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.board.controller.PacmanController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.util.Duration;

public class EntryTimer extends View {

    private static final int AMOUNT_SECONDS = 3;
    private Timeline timer;
    private int counter;
    private Label timerLabel;
    private PacmanController pacmanController;

    public EntryTimer() {
        timer = new Timeline();
    }

    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();
//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
//        pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.setTranslateX();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vBox);
        vBox.getChildren().add(createScoreLabel());
        pane.toFront();



//        pane.getC


        return pane;
    }

    public Label createScoreLabel()
    {
        timerLabel = new Label("3");
        timerLabel.setFont(new Font(40));
        timerLabel.setTextFill(Color.WHITE);
        pane.getChildren().add(timerLabel);

        return timerLabel;
    }

    private void updateLabel(String newCounterText)
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                timerLabel.setText(newCounterText);
            }
        });
    }

    public void startEntryTimer()
    {
        App.setPlaying(true);
        setCounter(AMOUNT_SECONDS);
        updateLabel(String.valueOf(getCounter()));
        getTimerLabel().setVisible(true);
        KeyFrame actionsOnTime = new KeyFrame(Duration.millis(1000), new EventHandler() {
            @Override
            public void handle(Event event) {
                decrement();
                if (getCounter() == 0) {
                    updateLabel("START");
//                    timer.stop();
                } else {
                    updateLabel(String.valueOf(getCounter()));
                }
            }
        });


        timer = new Timeline();

        timer.getKeyFrames().clear();
        timer.getKeyFrames().add(actionsOnTime);
        timer.setDelay(Duration.millis(1000));

        timer.setCycleCount(AMOUNT_SECONDS + 1);
        timer.setAutoReverse(false);
        timer.play();

        timer.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                App.clearAllMazesController();
                App.createMazeTimeline(App.root);
                getPacmanController().getControlledObject().setSelectFirstPoint(false);
                App.play();
                getTimerLabel().setVisible(false);
                App.setPlaying(true);
            }
        });
    }

    public void play()
    {
        if (timer != null) {
            timer.play();
        }
    }

    public void pause()
    {
        if (timer != null) {
            timer.pause();
        }
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    private void decrement()
    {
        counter--;
    }

    public Label getTimerLabel() {
        return timerLabel;
    }

    public void setTimerLabel(Label timerLabel) {
        this.timerLabel = timerLabel;
    }

    public Timeline getTimer() {
        return timer;
    }

    public void setTimer(Timeline timer) {
        this.timer = timer;
    }

    public PacmanController getPacmanController() {
        return pacmanController;
    }

    public void setPacmanController(PacmanController pacmanController) {
        this.pacmanController = pacmanController;
    }
}
