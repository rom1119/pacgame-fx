package com.pacgame.view;

import com.pacgame.App;
import com.pacgame.event.eventHandler.menu.OnExitSelect;
import com.pacgame.event.eventHandler.menu.OnMainSettingsSelect;
import com.pacgame.event.eventHandler.menu.OnReadGameSelect;
import com.pacgame.event.eventHandler.menu.OnStartNewGameSelect;
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

public class MainMenu extends Menu {
    private Label startGameLabel;
    private Label readGameLabel;
    private Label settingsLabel;
    private Label exitLabel;
    private MainSettings mainSettings;

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

        VBox vBox = new VBox();
        pane.setBackground(new Background(new BackgroundFill(new Color(0, 0, 0, 0.8), CornerRadii.EMPTY, Insets.EMPTY)));
//        pane.toFront();
//        vBox.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 25, 0));
        pane.getChildren().add(vBox);
        vBox.getChildren().add(createStartGameLabel());
        vBox.getChildren().add(createReadGameLabel());
        vBox.getChildren().add(createSettingsLabel());
        vBox.getChildren().add(createExitLabel());


        menuOptions.addAll(startGameLabel, readGameLabel, settingsLabel, exitLabel);
        removeBorderColorMenuOptions();
        checkMenuOption((Label) menuOptions.get(0));
        setOnMouseOver();
        setOnMouseDoubleClick();

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
        startGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnStartNewGameSelect(this));
    }

    private void setOnReadGameSelect()
    {
        readGameLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnReadGameSelect(this));
    }

    private void setOnSettingsSelect()
    {
        settingsLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnMainSettingsSelect(this));
    }

    private void setOnExitSelect()
    {
        exitLabel.addEventHandler(KeyEvent.KEY_PRESSED, new OnExitSelect(this));
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
}
