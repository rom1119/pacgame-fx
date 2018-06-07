package com.pacgame.view;

import com.pacgame.View;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameInfo extends View {

    private Label score;
    private Label lives;

    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();
        VBox vBox = new VBox();
        pane.setPadding(new Insets(10));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
//        pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.setTranslateX();

        pane.getChildren().add(vBox);
        vBox.getChildren().add(createScoreLabel());
        vBox.getChildren().add(createScoreEl());

        VBox vBox2 = new VBox();
        pane.getChildren().add(vBox2);



        vBox2.getChildren().add(createLivesLabel());
        vBox2.getChildren().add(createLivesEl());
//        pane.getC


        return pane;
    }

    public Label createScoreLabel()
    {
        Label scoreLabel = new Label("Punkty: ");
        scoreLabel.setFont(new Font(18));
        pane.getChildren().add(scoreLabel);

        return scoreLabel;
    }

    public Label createLivesLabel()
    {
        Label livesLabel = new Label("Życia: ");
        livesLabel.setFont(new Font(18));
        pane.getChildren().add(livesLabel);

        return livesLabel;
    }

    public Label createScoreEl()
    {
        score = new Label("");
        score.setFont(new Font(18));
        pane.getChildren().add(score);

        return score;
    }

    public Label createLivesEl()
    {
        lives = new Label("");
        lives.setFont(new Font(18));
        pane.getChildren().add(lives);

        return lives;
    }

    public Label getLives() {
        return lives;
    }

    public void setLives(Label lives) {
        this.lives = lives;
    }

    public Label getScore() {
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }
}
