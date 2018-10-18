package com.pacgame.ui.component;

import com.pacgame.App;
import com.pacgame.data.model.User;
import com.pacgame.ui.event.eventHandler.OnLogout;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class GameInfo extends View {

    private Label score;
    private Label lives;
    private Button logout;
    private Label loggedAs;

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
        VBox vBox3 = new VBox();
        pane.getChildren().add(vBox3);


        vBox2.getChildren().add(createLivesLabel());
        vBox2.getChildren().add(createLivesEl());

        vBox2.getChildren().add(createLogoutBtn());
        vBox2.getChildren().add(createLoggedAsLabel());

        setOnLoggedUserChange();
//        pane.getC


        return pane;
    }

    public Label createScoreLabel()
    {
        Label scoreLabel = new Label("Punkty: ");
        scoreLabel.setFont(new Font(18));

        return scoreLabel;
    }

    public Label createLivesLabel()
    {
        Label livesLabel = new Label("Życia: ");
        livesLabel.setFont(new Font(18));

        return livesLabel;
    }

    public Label createScoreEl()
    {
        score = new Label("");
        score.setFont(new Font(18));

        return score;
    }

    public Label createLivesEl()
    {
        lives = new Label("");
        lives.setFont(new Font(18));

        return lives;
    }

    public Button createLogoutBtn()
    {
        logout = new Button("Wyloguj");
        logout.setFont(new Font(18));
        logout.setVisible(false);

        setOnLogoutBtn();

        return logout;
    }

    public Label createLoggedAsLabel()
    {
        loggedAs = new Label("");
        loggedAs.setFont(new Font(18));
        loggedAs.setVisible(false);

        return loggedAs;
    }

    private void setOnLogoutBtn()
    {
        logout.setOnAction(new OnLogout(this, App.ApiService));
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

    private void setOnLoggedUserChange()
    {
        App.loggedUserProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                User loggedUser = App.getUser();
                if (newValue) {
                    if (loggedUser == null) {
                        return;
                    }
                    loggedAs.setText(loggedUser.getUsername());
                    loggedAs.setVisible(true);
                    logout.setVisible(true);
                } else {
                    loggedAs.setText("");
                    loggedAs.setVisible(false);
                    logout.setVisible(false);
                }


            }
        });
    }

    public void showAlert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Problem z wylogowaniem");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);

        alert.showAndWait();
    }
}
