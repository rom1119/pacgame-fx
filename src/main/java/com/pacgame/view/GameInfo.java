package com.pacgame.view;

import com.pacgame.View;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameInfo extends View {

    private FlowPane pane;

    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();
        pane.setPadding(new Insets(10));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
//        pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.setTranslateX();

        Label pointsLabel = new Label("Punkty: ");
        pointsLabel.setFont(new Font(18));
        pane.getChildren().add(pointsLabel);
//        pane.getC


        return pane;
    }

    public Label getScoreLabel()
    {
        Label score = new Label("");
        score.setFont(new Font(18));
        pane.getChildren().add(score);

        return score;
    }


}
