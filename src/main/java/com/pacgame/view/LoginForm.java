package com.pacgame.view;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import com.pacgame.event.eventHandler.menu.OnLoginUser;
import com.pacgame.event.eventHandler.menu.OnRegisterFormSelect;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginForm extends View {

    private Label emailLabel;
    private TextField emailEl;

    private Label passwordLabel;
    private PasswordField passwordEl;

    private Button loginBtn;
    private Button registerBtn;

    private RegisterForm registerForm;

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
        vBox.getChildren().add(createEmailLabel());
        vBox.getChildren().add(createEmailEl());
        vBox.getChildren().add(createPasswordLabel());
        vBox.getChildren().add(createPasswordEl());


        BorderPane buttons = new BorderPane();
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createLoginButton());
        buttons.setRight(createRegisterButton());

        vBox.getChildren().add(buttons);


        hide();

        pane.toFront();

        return pane;
    }

    private Label createEmailLabel()
    {
        emailLabel = new Label("Email: ");
        emailLabel.setFont(new Font(30));
        emailLabel.setTextFill(Color.WHITE);

        return emailLabel;
    }

    private TextField createEmailEl()
    {
        emailEl = new TextField();
        emailEl.setMaxWidth(250);


        return emailEl;
    }

    private Label createPasswordLabel()
    {
        passwordLabel = new Label("Email: ");
        passwordLabel.setFont(new Font(30));
        passwordLabel.setTextFill(Color.WHITE);

        return passwordLabel;
    }

    private PasswordField createPasswordEl()
    {
        passwordEl = new PasswordField();
        passwordEl.setMaxWidth(250);

        return passwordEl;
    }

    private Button createLoginButton()
    {
        loginBtn = new Button("Zaloguj");
        loginBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnLoginButton();

        return loginBtn;
    }

    private Button createRegisterButton()
    {
        registerBtn = new Button("Utwórz konto");
        registerBtn.setFont(new Font(20));

        setOnRegisterButton();

//        backBtn.setTextFill(Color.WHITE);

        return registerBtn;
    }



    private void setOnLoginButton()
    {
        loginBtn.setOnAction(new OnLoginUser(this, App.getMainMenu()));
    }

    private void setOnRegisterButton()
    {
        registerBtn.setOnAction(new OnRegisterFormSelect(this, getRegisterForm()));
    }


    public RegisterForm getRegisterForm() {
        return registerForm;
    }

    public void setRegisterForm(RegisterForm registerForm) {
        this.registerForm = registerForm;
    }


    public boolean isValid() {

        if (emailEl.getText().isEmpty()) {
            VBox vBox = (VBox) getPane().getChildren().get(0);
            return false;
        }

        if (passwordEl.getText().isEmpty()) {
            return false;
        }

        return true;
    }


}