package com.pacgame.ui.component;

import com.pacgame.App;
import com.pacgame.ui.event.eventHandler.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainMenu extends Menu {
    private Label startGameLabel;
    private Label readGameLabel;
    private Label loginLabel;
    private Label registerLabel;
    private Label userAccountLabel;
    private Label usersRankingLabel;
    private Label settingsLabel;
    private Label exitLabel;

    private MainSettings mainSettings;
    private MainReadGame mainReadGame;
    private LoginForm loginForm;
    private RegisterForm registerForm;
    private UserAccount userAccount;
    private UsersRanking usersRanking;
    private VBox mainBox;

    public MainMenu(Scene scene) {
        super(scene);
    }

    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();

//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setAlignment(Pos.CENTER);

        mainBox = new VBox();
        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.toFront();
//        mainBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(mainBox);

        updateMenuElementsVisibility(false);


        pane.toFront();

        return pane;
    }

    public Label createStartGameLabel()
    {
        startGameLabel = new Label("Rozpocznij");
        startGameLabel.setFont(new Font(40));
        startGameLabel.setTextFill(Color.WHITE);

        setOnStartGameSelect();

        return startGameLabel;
    }

    public Label createReadGameLabel()
    {
        readGameLabel = new Label("Wczytaj grę");
        readGameLabel.setFont(new Font(40));
        readGameLabel.setTextFill(Color.WHITE);

        setOnReadGameSelect();

        return readGameLabel;
    }

    public Label createLoginLabel()
    {
        loginLabel = new Label("Zaloguj się");
        loginLabel.setFont(new Font(40));
        loginLabel.setTextFill(Color.WHITE);

        setOnLoginSelect();

        return loginLabel;
    }

    public Label createRegisterLabel()
    {
        registerLabel = new Label("Załóż konto");
        registerLabel.setFont(new Font(40));
        registerLabel.setTextFill(Color.WHITE);

        setOnRegisterSelect();

        return registerLabel;
    }

    public Label createUsersRankingLabel()
    {
        usersRankingLabel = new Label("Ranking użytkowników");
        usersRankingLabel.setFont(new Font(40));
        usersRankingLabel.setTextFill(Color.WHITE);

        setOnUsersRankingSelect();

        return usersRankingLabel;
    }



    public Label createUserAccountLabel()
    {
        userAccountLabel = new Label("Konto użytkownika");
        userAccountLabel.setFont(new Font(40));
        userAccountLabel.setTextFill(Color.WHITE);

        setOnUserAccountSelect();

        return userAccountLabel;
    }

    public Label createSettingsLabel()
    {
        settingsLabel = new Label("Ustawienia");
        settingsLabel.setFont(new Font(40));
        settingsLabel.setTextFill(Color.WHITE);

        setOnSettingsSelect();

        return settingsLabel;
    }

    public Label createExitLabel()
    {
        exitLabel = new Label("Wyjście");
        exitLabel.setFont(new Font(40));
        exitLabel.setTextFill(Color.WHITE);

        setOnExitSelect();

        return exitLabel;
    }

    private void setOnStartGameSelect()
    {
        startGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnStartNewGameSelect(this, null));
    }

    private void setOnReadGameSelect()
    {
        readGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnReadGameSelect(this, getMainReadGame()));
    }

    private void setOnLoginSelect()
    {
        loginLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnLoginFormSelect(this, getLoginForm()));
    }
    private void setOnRegisterSelect()
    {
        registerLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnRegisterFormSelect(this, getRegisterForm()));
    }

    private void setOnUsersRankingSelect() {
        usersRankingLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnUsersRankingSelect(this, getUsersRanking(), App.ApiService));
    }

    private void setOnUserAccountSelect()
    {
        userAccountLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnUserAccountSelect(this, getUserAccount()));
    }

    private void setOnSettingsSelect()
    {
        settingsLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnMainSettingsSelect(this, getMainSettings()));
    }

    private void setOnExitSelect()
    {
        exitLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnExitSelect(this, null));
    }

    public void updateFocusMenuOption()
    {
        getCheckedMenuOption().requestFocus();
    }

    public MainSettings getMainSettings() {
        return mainSettings;
    }

    public void setMainSettings(MainSettings mainSettings) {
        this.mainSettings = mainSettings;
    }

    public MainReadGame getMainReadGame() {
        return mainReadGame;
    }

    public void setMainReadGame(MainReadGame mainReadGame) {
        this.mainReadGame = mainReadGame;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public RegisterForm getRegisterForm() {
        return registerForm;
    }

    public void setRegisterForm(RegisterForm registerForm) {
        this.registerForm = registerForm;
    }

    public Label getStartGameLabel() {
        return startGameLabel;
    }

    public Label getReadGameLabel() {
        return readGameLabel;
    }

    public Label getLoginLabel() {
        return loginLabel;
    }

    public Label getUserAccountLabel() {
        return userAccountLabel;
    }

    public Label getSettingsLabel() {
        return settingsLabel;
    }

    public Label getExitLabel() {
        return exitLabel;
    }

    public Label getRegisterLabel() {
        return registerLabel;
    }

    public Label getUsersRankingLabel() {
        return usersRankingLabel;
    }

    public void setUsersRankingLabel(Label usersRankingLabel) {
        this.usersRankingLabel = usersRankingLabel;
    }

    public UsersRanking getUsersRanking() {
        return usersRanking;
    }

    public void setUsersRanking(UsersRanking usersRanking) {
        this.usersRanking = usersRanking;
    }

    public void updateMenuElementsVisibility(boolean isLoggedUser)
    {
        mainBox.getChildren().clear();
        if (isLoggedUser) {
            mainBox.getChildren().add(createStartGameLabel());
            mainBox.getChildren().add(createReadGameLabel());
//            mainBox.getChildren().add(createLoginLabel());
//            mainBox.getChildren().add(createRegisterLabel());
            mainBox.getChildren().add(createUsersRankingLabel());
            mainBox.getChildren().add(createUserAccountLabel());
            mainBox.getChildren().add(createSettingsLabel());
            mainBox.getChildren().add(createExitLabel());

            menuOptions.clear();
            menuOptions.addAll(startGameLabel, readGameLabel, usersRankingLabel, userAccountLabel, settingsLabel, exitLabel);

//            getStartGameLabel().setVisible(true);
//            getReadGameLabel().setVisible(true);
//            getSettingsLabel().setVisible(true);
//            getUserAccountLabel().setVisible(true);
//            getUsersRankingLabel().setVisible(true);
//
//            getRegisterLabel().setVisible(false);
//            getLoginLabel().setVisible(false);
        } else {
            mainBox.getChildren().add(createLoginLabel());
            mainBox.getChildren().add(createRegisterLabel());
            mainBox.getChildren().add(createExitLabel());

            menuOptions.clear();
            menuOptions.addAll(loginLabel, registerLabel, exitLabel);

//            getStartGameLabel().setVisible(false);
//            getReadGameLabel().setVisible(false);
//            getSettingsLabel().setVisible(false);
//            getUserAccountLabel().setVisible(false);
//            getUsersRankingLabel().setVisible(false);
//
//            getRegisterLabel().setVisible(true);
//            getLoginLabel().setVisible(true);
        }

        removeBorderColorMenuOptions();
        checkMenuOption((Label) menuOptions.get(0));
        setOnMouseOver();
        setOnMouseClick();

        setOnChangeCheckedOption();
        setOnKeyPress();

        setIterator(0);
    }



}
