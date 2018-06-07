package com.pacgame.view;

import com.pacgame.View;
import com.pacgame.event.eventHandler.menu.OnBackFromMainSettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainSettings extends View {

    private Label speedLabel;
    private Slider speedEl;

    private Button back;
    private Button save;

    private MainMenu mainMenu;

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
        vBox.getChildren().add(createSpeedLabel());
        vBox.getChildren().add(createSpeedEl());

        BorderPane buttons = new BorderPane();

        buttons.setPrefWidth(width);
        buttons.setPrefHeight(height);

        buttons.setLeft(createBackButton());
        buttons.setRight(createSaveButton());

        vBox.getChildren().add(buttons);


        invisible();

        pane.toFront();

        return pane;
    }

    public Label createSpeedLabel()
    {
        speedLabel = new Label("Prędkość: ");
        speedLabel.setFont(new Font(30));
        speedLabel.setTextFill(Color.WHITE);

        return speedLabel;
    }

    public Slider createSpeedEl()
    {
        speedEl = new Slider();
        speedEl.setShowTickMarks(true);
        speedEl.setShowTickLabels(true);
        speedEl.setMin(0);
        speedEl.setMax(100);
        speedEl.setValue(30);
        speedEl.setMajorTickUnit(50);
        speedEl.setMinorTickCount(5);
        speedEl.setBlockIncrement(10);

        return speedEl;
    }

    public Button createBackButton()
    {
        back = new Button("Powrót");
        back.setFont(new Font(20));
//        back.setTextFill(Color.WHITE);

        setOnBackButton();

        return back;
    }

    public Button createSaveButton()
    {
        save = new Button("Zapisz");
        save.setFont(new Font(20));

        setOnSaveButton();

//        back.setTextFill(Color.WHITE);

        return save;
    }

    private void setOnBackButton()
    {
        back.setOnAction(new OnBackFromMainSettings(this, getMainMenu()));
    }

    private void setOnSaveButton()
    {
        save.setOnAction(new OnBackFromMainSettings(this, getMainMenu()));
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
}
