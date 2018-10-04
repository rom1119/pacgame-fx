package com.pacgame.ui.component;

import com.pacgame.App;
import com.pacgame.board.controller.MazeController;
import com.pacgame.board.controller.PacmanController;
import com.pacgame.ui.event.eventHandler.OnBackToMenu;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.springframework.stereotype.Component;

@Component
public class UserAccount extends SubView {

    private Label idLabel;
    private Label idEl;

    private Label emailLabel;
    private Label emailEl;

    private Label nameLabel;
    private Label nameEl;

    private Label lastNameLabel;
    private Label lastNameEl;

    private Label imageLabel;
    private Label imageEl;

    private Label rolesLabel;
    private Label rolesEl;

    private Label fullScoreLabel;
    private Label fullScoreEl;

    private Button backBtn;

    private Menu menu;

    private PacmanController pacmanController;
    private ObservableList<MazeController> mazeCollection;


    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();

//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
//        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.toFront();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vBox);

        vBox.getChildren().add(createIdLabel());
        vBox.getChildren().add(createIdEl());

        vBox.getChildren().add(createNameLabel());
        vBox.getChildren().add(createNameEl());

        vBox.getChildren().add(createLastNameLabel());
        vBox.getChildren().add(createLastNameEl());

        vBox.getChildren().add(createEmailLabel());
        vBox.getChildren().add(createEmailEl());

        vBox.getChildren().add(createFullScoreLabel());
        vBox.getChildren().add(createFullScoreEl());

        vBox.getChildren().add(createRolesLabel());
        vBox.getChildren().add(createRolesEl());

        BorderPane buttons = new BorderPane();
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createBackButton());

        vBox.getChildren().add(buttons);


        hide();

        pane.toFront();

        return pane;
    }

    private Label createLastNameLabel()
    {
        lastNameLabel = new Label("Nazwisko: ");
        lastNameLabel.setFont(new Font(20));
        lastNameLabel.setTextFill(Color.WHITE);

        return lastNameLabel;
    }

    private Label createLastNameEl()
    {
        lastNameEl = new Label();
        lastNameEl.setMaxWidth(250);

        return lastNameEl;
    }

    private Label createNameLabel()
    {
        nameLabel = new Label("Imię: ");
        nameLabel.setFont(new Font(20));
        nameLabel.setTextFill(Color.WHITE);

        return nameLabel;
    }

    private Label createNameEl()
    {
        nameLabel = new Label();
        nameLabel.setMaxWidth(250);

        return nameLabel;
    }

    private Label createIdLabel()
    {
        idLabel = new Label("ID użytkownika: ");
        idLabel.setFont(new Font(20));
        idLabel.setTextFill(Color.WHITE);

        return idLabel;
    }

    private Label createRolesLabel()
    {
        rolesLabel = new Label("Role użytkownika w systemie: ");
        rolesLabel.setFont(new Font(20));
        rolesLabel.setTextFill(Color.WHITE);

        return rolesLabel;
    }

    private Label createRolesEl()
    {
        rolesEl = new Label();
        rolesEl.setMaxWidth(250);

        return rolesEl;
    }

    private Label createIdEl()
    {
        idEl = new Label();
        idEl.setMaxWidth(250);

        return idEl;
    }

    private Label createEmailLabel()
    {
        emailLabel = new Label("Email: ");
        emailLabel.setFont(new Font(20));
        emailLabel.setTextFill(Color.WHITE);

        return emailLabel;
    }

    private Label createEmailEl()
    {
        emailEl = new Label();
        emailEl.setMaxWidth(250);


        return emailEl;
    }

    private Label createFullScoreLabel()
    {
        fullScoreLabel = new Label("Punkty: ");
        fullScoreLabel.setFont(new Font(20));
        fullScoreLabel.setTextFill(Color.WHITE);

        return fullScoreLabel;
    }

    private Label createFullScoreEl()
    {
        fullScoreEl = new Label();
        fullScoreEl.setMaxWidth(250);

        return fullScoreEl;
    }



    private Button createBackButton()
    {
        backBtn = new Button("Powrót do menu");
        backBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnBackButton();

        return backBtn;
    }




    private void setOnBackButton()
    {
        backBtn.setOnAction(new OnBackToMenu(this, App.getMainMenu()));
    }



    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
