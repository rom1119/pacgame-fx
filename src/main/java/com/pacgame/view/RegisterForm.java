package com.pacgame.view;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.controller.MazeController;
import com.pacgame.controller.PacmanController;
import com.pacgame.event.eventHandler.menu.OnLoginFormSelect;
import com.pacgame.event.eventHandler.menu.OnRegisterUser;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RegisterForm extends View {
    private Label emailLabel;
    private TextField emailEl;

    private Label passwordLabel;
    private PasswordField passwordEl;

    private Label passwordConfLabel;
    private PasswordField passwordConfEl;

    private CheckBox agreeTerms;

    private Button backToLoginBtn;
    private Button registerBtn;

    private LoginForm loginForm;

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
        vBox.getChildren().add(createPasswordEl());
        vBox.getChildren().add(createPasswordConfLabel());
        vBox.getChildren().add(createPasswordConfEl());
        vBox.getChildren().add(createPasswordLabel());
        vBox.getChildren().add(createAgreeTermsEl());

        BorderPane buttons = new BorderPane();
        vBox.setAlignment(Pos.BOTTOM_CENTER);


        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createBackToLoginButton());
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
        passwordLabel = new Label("Hasło: ");
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

    private Label createPasswordConfLabel()
    {
        passwordConfLabel = new Label("Potwierdź hasło: ");
        passwordConfLabel.setFont(new Font(30));
        passwordConfLabel.setTextFill(Color.WHITE);

        return passwordConfLabel;
    }

    private PasswordField createPasswordConfEl()
    {
        passwordConfEl = new PasswordField();
        passwordConfEl.setMaxWidth(250);

        return passwordConfEl;
    }

    private CheckBox createAgreeTermsEl()
    {
        agreeTerms = new CheckBox("Akceptuję warunki");
        agreeTerms.setMaxWidth(250);

        return agreeTerms;
    }


    private Button createBackToLoginButton()
    {
        backToLoginBtn = new Button("Wróć do logowania");
        backToLoginBtn.setFont(new Font(20));
//        backBtn.setTextFill(Color.WHITE);

        setOnLoginButton();

        return backToLoginBtn;
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
        backToLoginBtn.setOnAction(new OnLoginFormSelect(this, getLoginForm()));
    }

    private void setOnRegisterButton()
    {
        registerBtn.setOnAction(new OnRegisterUser(this, App.getMainMenu()));
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public boolean isValid() {

        if (emailEl.getText().isEmpty()) {
            VBox vBox = (VBox) getPane().getChildren().get(0);
            return false;
        }

        if (passwordEl.getText().isEmpty()) {
            return false;
        }

        if (passwordConfEl.getText().isEmpty()) {
            return false;
        }

        if (!agreeTerms.isSelected()) {
            return false;
        }

        return true;
    }
}
