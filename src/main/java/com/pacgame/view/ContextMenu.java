package com.pacgame.view;

import com.pacgame.App;
import com.pacgame.View;
import com.pacgame.event.eventHandler.menu.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;

public class ContextMenu extends Menu {

    private Label resumeGameLabel;
    private Label startNewGameLabel;
    private Label saveGameLabel;
    private Label settingsLabel;
    private Label exitToMainMenuLabel;

    private ContextSettings contextSettings;
    private ContextSaveGame contextSaveGame;


    public ContextMenu(Scene scene) {
        super(scene);
    }


    @Override
    public Node getView(int width, int height) {
        pane = new FlowPane();

//        pane.setPadding(new Insets(100));
        pane.setPrefWidth(width);
        pane.setPrefHeight(height);
        pane.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.toFront();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vBox);
        vBox.getChildren().add(createResumeGameLabel());
        vBox.getChildren().add(createStartNewGameLabel());
        vBox.getChildren().add(saveGameLabel());
        vBox.getChildren().add(createSettingsLabel());
        vBox.getChildren().add(createExitToMainMenuLabel());


        menuOptions.addAll(resumeGameLabel, startNewGameLabel, saveGameLabel, settingsLabel, exitToMainMenuLabel);
        removeBorderColorMenuOptions();
        checkMenuOption((Label) menuOptions.get(0));

        invisible();
        setCheckedMenuOptionOnFirst();
        setOnMouseOver();
        setOnMouseDoubleClick();

        return pane;
    }

    public Label createStartNewGameLabel()
    {
        startNewGameLabel = new Label("Graj od nowa");
        startNewGameLabel.setFont(new Font(40));
        startNewGameLabel.setTextFill(Color.WHITE);

        setOnStartNewGameSelect();

        return startNewGameLabel;
    }

    public Label createResumeGameLabel()
    {
        resumeGameLabel = new Label("Powróć do gry");
        resumeGameLabel.setFont(new Font(40));
        resumeGameLabel.setTextFill(Color.WHITE);

        setOnResumeGameSelect();

        return resumeGameLabel;
    }

    public Label saveGameLabel()
    {
        saveGameLabel = new Label("Zapisz grę");
        saveGameLabel.setFont(new Font(40));
        saveGameLabel.setTextFill(Color.WHITE);

        setSaveGameSelect();

        return saveGameLabel;
    }


    public Label createSettingsLabel()
    {
        settingsLabel = new Label("Ustawienia");
        settingsLabel.setFont(new Font(40));
        settingsLabel.setTextFill(Color.WHITE);

        setOnContextSettingsSelect();

        return settingsLabel;
    }


    public Label createExitToMainMenuLabel()
    {
        exitToMainMenuLabel = new Label("Menu główne");
        exitToMainMenuLabel.setFont(new Font(40));
        exitToMainMenuLabel.setTextFill(Color.WHITE);

        setOnExitToMainMenuSelect();

        return exitToMainMenuLabel;
    }

    private void setOnStartNewGameSelect()
    {
        startNewGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnStartNewGameSelect(this));
    }


    private void setOnResumeGameSelect()
    {
        resumeGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnResumeGameSelect(this));
    }

    private void setSaveGameSelect()
    {
        saveGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnSaveGameSelect(this));
    }

    private void setOnContextSettingsSelect() {
        settingsLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnContextSettingsSelect(this));
    }

    private void setOnExitToMainMenuSelect()
    {
        exitToMainMenuLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnExitToMainMenuSelect(this));
    }
    public void updateFocusMenuOption()
    {
        getCheckedMenuOption().requestFocus();
    }

    public ContextSettings getContextSettings() {
        return contextSettings;
    }

    public void setContextSettings(ContextSettings contextSettings) {
        this.contextSettings = contextSettings;
    }

    public ContextSaveGame getContextSaveGame() {
        return contextSaveGame;
    }

    public void setContextSaveGame(ContextSaveGame contextSaveGame) {
        this.contextSaveGame = contextSaveGame;
    }
}
